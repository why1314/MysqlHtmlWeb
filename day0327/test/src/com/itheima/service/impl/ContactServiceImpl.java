package com.itheima.service.impl;

import com.itheima.dao.ContactDao;
import com.itheima.dao.impl.ContactDaoImp;
import com.itheima.entity.Contact;
import com.itheima.entity.PageBean;
import com.itheima.service.ContactService;
import com.itheima.utils.JDBCUtils;
import com.itheima.utils.PageUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-26-15:56
 */
public class ContactServiceImpl implements ContactService {
    private ContactDao dao = new ContactDaoImp();


    @Override
    public List<Contact> findAll() {

        return dao.findAll();
    }


    @Override
    public int add(Contact contact) {

        return dao.add(contact);
    }

    @Override
    public void deleteChecked(String[] cids) {
//        1.获取连接池对象
        DataSource dataSource = JDBCUtils.getDataSource();
//        2.创建jdbcTemplate实例 // template从连接池中获取一个连接 conn
        JdbcTemplate template = new JdbcTemplate(dataSource);
//        3.启动事务管理器（获取datasoutce操作数据库连接对象conn并绑定当前线程中）
        TransactionSynchronizationManager.initSynchronization();
//        4.获取连接 : 获取JdbcTemplate所使用的连接对象
        Connection conn = DataSourceUtils.getConnection(dataSource);
        try {

//            5.将连接的事务,设置为手动事务提交
            conn.setAutoCommit(false);
//            ===== 业务处理
            dao.deleteChecked(template, cids);
//            提交事务
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
//                回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
//             将conn对象和当前线程解除绑定
            TransactionSynchronizationManager.clearSynchronization();
            try {
//                 修改为自动事务提交
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public PageBean<Contact> queryByConditions(String name, String qq, int curPage, int pageSize) {

//      查询符合条件的联系人总条数
        int totalCount = dao.findTotalCountByConditions(name, qq);


//        封装PageBean对象
        PageBean<Contact> pb = new PageBean<>(curPage, pageSize, totalCount);

//        查询符合条件的联系人
        List<Contact> list = dao.queryByConditions(name, qq,curPage,pageSize);

        //        前5后4动态分页，计算起始页
        int[] ints = PageUtils.pagination(curPage, pb.getTotalPage());
        pb.setStart(ints[0]);
        pb.setEnd(ints[1]);

        pb.setData(list);

        return pb;
    }

    @Override
    public int deleteById(String id) {
        return dao.deleteById(id);

    }

    @Override
    public List<Contact> findByPage(int curPage, int pageSize) {
        return dao.queryByPage(curPage, pageSize);
    }

    @Override
    public PageBean<Contact> queryByPage(int curPage, int pageSize) {

//        查询总记录数
        int totalCount = dao.findTotalCount();

//        封装一个PageBean对象totalPage总页数可以自动求出
        PageBean<Contact> pb = new PageBean<>(curPage, pageSize, totalCount);

//        查询分页数据
        List<Contact> list = dao.queryByPage(pb.getCurPage(), pageSize);

//        前5后4动态分页，计算起始页
        int[] ints = PageUtils.pagination(curPage, pb.getTotalPage());
        pb.setStart(ints[0]);
        pb.setEnd(ints[1]);

        pb.setData(list);

        return pb;
    }

    @Override
    public Contact findById(String id) {
        return dao.findById(id);
    }

    @Override
    public void update(Contact contact) {
        dao.update(contact);
    }
}
