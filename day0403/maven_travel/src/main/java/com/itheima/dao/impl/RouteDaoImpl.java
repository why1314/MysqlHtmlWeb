package com.itheima.dao.impl;

import com.itheima.dao.RouteDao;
import com.itheima.entity.Category;
import com.itheima.entity.Route;
import com.itheima.entity.RouteImg;
import com.itheima.entity.Seller;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-06-10:14
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public Route findRouteByRid(String rid) throws Exception {
//        查询线路的基本信息
        String sql = "SELECT * FROM tab_route WHERE rid=?";
        Route route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
//          根据查询结果，查询当前线路所包含的图片
        sql = "SELECT * FROM tab_category WHERE cid=?";
        Category category = template.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class), route.getCid());
        route.setCategory(category);

//         根据查询结果，查询当前线路所属的分类CategoryList<RouteImg>
        sql = "SELECT * FROM tab_route_img WHERE rid=?";
        List<RouteImg> routeImgs = template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), route.getRid());
        route.setRouteImgList(routeImgs);

//        根据查询结果，查询当前线路所属的商家
        sql = "SELECT * FROM tab_seller WHERE sid=?";
        Seller seller = template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), route.getSid());
        route.setSeller(seller);

        return route;
    }

    @Override
    public List<Route> findRouteByPage(int startIndex, int pageSize, String cid, String rname) {
        List<Route> routeList = null;
        List list = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("SELECT * FROM tab_route WHERE 1=1");
            if (cid != null && !"".equals(cid)) {
                sql.append(" and cid =? ");
                list.add(cid);
            }
            if (rname != null && !"".equals(rname)) {
                sql.append(" and rname like ? ");
                list.add("%" + rname + "%");
            }
            sql.append(" limit ?,?");
            list.add(startIndex);
            list.add(pageSize);
            Object[] params = list.toArray();
            routeList = template.query(sql.toString(), new BeanPropertyRowMapper<Route>(Route.class), params);

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return routeList;
    }

    @Override
    public int findTotalCount(String cid, String rname) throws Exception {

        StringBuilder sql = new StringBuilder("SELECT count(*) FROM tab_route WHERE 1=1");
        List list = new ArrayList<>();
        if (cid != null && !"".equals(cid)) {
            sql.append(" and cid =? ");
            list.add(cid);
        }
        if (rname != null && !"".equals(rname)) {
            sql.append(" and rname like ? ");
            list.add("%" + rname + "%");
        }
        Object[] params = list.toArray();
        return template.queryForObject(sql.toString(), int.class, params);

    }
}
