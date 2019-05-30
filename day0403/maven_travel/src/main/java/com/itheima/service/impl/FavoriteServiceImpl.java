package com.itheima.service.impl;

import com.itheima.dao.FavoriteDao;
import com.itheima.entity.Favorite;
import com.itheima.entity.PageBean;
import com.itheima.entity.Route;
import com.itheima.service.FavoriteService;
import com.itheima.utils.BeanFactoryUtils;
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
 * @date 2019-04-07-11:11
 */
public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao dao = (FavoriteDao) BeanFactoryUtils.getBean("FavoriteDao");


    @Override
    public PageBean<Route> findRouteByRank(int pageNumber, int pageSize) throws Exception {
        //        查询总条数
        int totalCount = dao.findTotalCountByRank();
//        创建PageBean对象
        PageBean<Route> pb = new PageBean<>(pageNumber, pageSize, totalCount);
//        查询当前页面的显示数据
//        起始索引
        int startIndex = pb.getStartIndex();
        List<Route> routeList = dao.findRouteByRank(startIndex, pageSize);

        pb.setData(routeList);
//      前五后四
        int[] ints = PageUtils.pagination(pageNumber, pb.getTotalPage());

        pb.setStart(ints[0]);

        pb.setEnd(ints[1]);

        return pb;
    }

    /**
     * 分页查询我的收藏
     *
     * @param pageNumber
     * @param pageSize
     * @param uid
     * @return
     * @throws Exception
     */
    @Override
    public PageBean<Favorite> findMyFavoriteByPage(int pageNumber, int pageSize, int uid) throws Exception {
//        查询总条数
        int totalCount = dao.findMyFavoriteCount(uid);
//        创建PageBean对象
        PageBean<Favorite> pb = new PageBean<>(pageNumber, pageSize, totalCount);
//        查询当前页面的显示数据
//        起始索引
        int startIndex = pb.getStartIndex();
        List<Favorite> favoriteList = dao.findMyFavoriteByPage(startIndex, pageSize, uid);

        pb.setData(favoriteList);
//      前五后四
        int[] ints = PageUtils.pagination(pageNumber, pb.getTotalPage());

        pb.setStart(ints[0]);

        pb.setEnd(ints[1]);

        return pb;
    }

    @Override
    public void addMyFavorite(Favorite fa) throws Exception {
        // 今天我们只是使用spring的事务控制而已,使用spring的事务代码时复制即可
        //1.获取连接池对象
        DataSource dataSource = JDBCUtils.getDataSource();
        //2.创建jdbcTemplate实例 // template从连接池中获取一个连接 conn1
        JdbcTemplate template = new JdbcTemplate(dataSource);
        //3.启动事务管理器(将conn和当前线程做绑定) treadLocal :  conn1
        TransactionSynchronizationManager.initSynchronization();
        //4.获取连接 : 获取JdbcTemplate所使用的连接对象
        Connection conn = DataSourceUtils.getConnection(dataSource);  // conn1
        try {
            //5.将连接的事务,设置为手动事务提交
            conn.setAutoCommit(false);
            //===== 业务处理
            //调用dao,向中间表添加数据信息
            dao.addMyFavorite(fa, template);
            //更改当前线路总的收藏次数
            dao.updateRouteCount(fa.getRid(), template);
            // 提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 事务回顾
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            // 将异常抛给调用者,告知执行失败
            throw e;
        } finally {
            // 将conn对象和当前线程解除绑定
            TransactionSynchronizationManager.clearSynchronization();
            // 修改为自动事务提交
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isFavorite(String rid, int uid) throws Exception {

        Favorite fa = dao.isFavorite(rid, uid);
//        false代表未收藏
//        true代表以收藏
        return fa == null ? false : true;
    }
}
