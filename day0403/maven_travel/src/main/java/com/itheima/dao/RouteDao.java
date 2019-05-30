package com.itheima.dao;

import com.itheima.entity.Category;
import com.itheima.entity.Route;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-06-10:14
 */
public interface RouteDao {
    /**
     * 查询当前线路下的信息数量
     * @param cid
     * @param rname
     * @return
     * @throws Exception
     */
    int findTotalCount(String cid, String rname) throws Exception;

    /**
     * 分页查询分类下的线路信息
     * @param startIndex
     * @param pageSize
     * @param s
     * @param cid
     * @return
     */
    List<Route> findRouteByPage(int startIndex, int pageSize, String cid, String rname) throws Exception;

    /**
     * 查询相关线路信息
     * @param rid
     * @return
     */
    Route findRouteByRid(String rid) throws Exception;


}
