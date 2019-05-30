package com.itheima.service;

import com.itheima.entity.Favorite;
import com.itheima.entity.PageBean;
import com.itheima.entity.Route;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-11:11
 */
public interface FavoriteService {
    /**
     * 是否已经收藏
     * @param rid
     * @param user
     * @return
     * @throws Exception
     */
    boolean isFavorite(String rid, int user) throws Exception;

    /**
     * 添加我的收藏
     * @param fa
     */
    void addMyFavorite(Favorite fa) throws Exception;

    /**
     *分页查询我的收藏
     * @param pageNumber
     * @param pageSize
     * @param uid
     * @return
     * @throws Exception
     */
    PageBean<Favorite> findMyFavoriteByPage(int pageNumber, int pageSize, int uid) throws Exception;

    /**
     * 分页查询收藏排行榜
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageBean<Route> findRouteByRank(int pageNumber, int pageSize) throws Exception;
}
