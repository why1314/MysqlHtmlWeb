package com.itheima.dao;

import com.itheima.entity.Favorite;
import com.itheima.entity.Route;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-11:27
 */
public interface FavoriteDao {
    /**
     * 查询当前用户是否收藏了当前线路
     * @param rid
     * @param uid
     * @return
     * @throws Exception
     */
    Favorite isFavorite(String rid, int uid) throws Exception;

    /**
     * 向中间表中添加收藏信息
     * @param fa
     * @param template
     * @throws Exception
     */
    void addMyFavorite(Favorite fa, JdbcTemplate template) throws Exception;

    /**
     * 更改当前线路的收藏次数
     * @param rid
     * @param template
     * @throws Exception
     */
    void updateRouteCount(Integer rid, JdbcTemplate template) throws Exception;

    /**
     * 查询总条数
     *
     * @param uid
     * @return
     * @throws Exception
     */
    int findMyFavoriteCount(int uid) throws Exception;

    /**
     * 查询当前页的线路信息
     * @param startIndex
     * @param pageSize
     * @param uid
     * @return
     * @throws Exception
     */
    List<Favorite> findMyFavoriteByPage(int startIndex, int pageSize, int uid) throws Exception;

    /**
     * 查询总条数
     * @return
     */
    int findTotalCountByRank() throws Exception;

    /**
     * 查询当前页的数据信息
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Route> findRouteByRank(int startIndex, int pageSize) throws Exception;
}
