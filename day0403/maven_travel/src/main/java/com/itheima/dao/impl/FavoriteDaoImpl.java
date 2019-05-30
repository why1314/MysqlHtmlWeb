package com.itheima.dao.impl;

import com.itheima.dao.FavoriteDao;
import com.itheima.entity.Favorite;
import com.itheima.entity.Route;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-11:27
 */
public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Route> findRouteByRank(int startIndex, int pageSize) throws Exception {
        String sql="SELECT * FROM tab_route ORDER BY COUNT DESC LIMIT ?,?";
        return template.query(sql,new BeanPropertyRowMapper<>(Route.class),startIndex,pageSize);
    }

    @Override
    public int findTotalCountByRank() throws Exception {
        String sql = "SELECT count(*) FROM tab_route ";

        return template.queryForObject(sql,int.class);
    }

    /**
     * 查询当前页线路信息
     *
     * @param startIndex
     * @param pageSize
     * @param uid
     * @return
     */
    @Override
    public List<Favorite> findMyFavoriteByPage(int startIndex, int pageSize, int uid) throws Exception {

        String sql = "select * from tab_favorite where uid=? limit ?,?";
        List<Favorite> list = template.query(sql, new BeanPropertyRowMapper<>(Favorite.class), uid, startIndex, pageSize);
        for (Favorite fa : list) {
            sql = "SELECT * FROM tab_route WHERE rid=?";
            Route route = template.queryForObject(sql, new BeanPropertyRowMapper<>(Route.class), fa.getRid());
            fa.setRoute(route);
        }
        return list;
    }


    @Override
    public int findMyFavoriteCount(int uid) throws Exception {

        String sql = "select count(*) from tab_favorite where uid=?";
        return template.queryForObject(sql, int.class, uid);

    }

    @Override
    public void updateRouteCount(Integer rid, JdbcTemplate jdbcTemplate) throws Exception {

        String sql = "update tab_route set count=count+1 where rid=?";
        jdbcTemplate.update(sql, rid);
    }

    @Override
    public void addMyFavorite(Favorite fa, JdbcTemplate jdbcTemplate) throws Exception {

        String sql = "insert into tab_favorite values(?,?,?)";
        jdbcTemplate.update(sql, fa.getRid(), fa.getDate(), fa.getUid());

    }

    @Override
    public Favorite isFavorite(String rid, int uid) {
        Favorite favorite = null;
        try {
            String sql = "select * from tab_favorite where rid=? and uid=?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<>(Favorite.class), rid, uid);
            return favorite;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return favorite;
    }
}
