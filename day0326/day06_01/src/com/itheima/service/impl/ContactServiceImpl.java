package com.itheima.service.impl;

import com.itheima.dao.ContactDao;
import com.itheima.dao.impl.ContactDaoImp;
import com.itheima.entity.Contact;
import com.itheima.service.ContactService;
import com.itheima.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

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
//        启动事务管理器（获取datasoutce操作数据库连接对象并绑定当前线程中）
        TransactionSynchronizationManager.initSynchronization();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
//            设置手动事务
            conn.setAutoCommit(false);
            dao.deleteChecked(template,cids);

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }


    }

    @Override
    public List<Contact> queryByConditions(String name, String qq) {
        return dao.queryByConditions(name,qq);
    }
}
