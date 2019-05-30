package com.itheima.service;

import com.itheima.entity.PageBean;
import com.itheima.entity.Route;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-06-10:09
 */
public interface RouteService {
    /**
     * 分离查询分类下的线路信息
     * @param pageNumber
     * @param pageSize
     * @param cid
     * @param rname
     * @return
     */
    PageBean<Route> findRouteByPage(int pageNumber, int pageSize, String cid, String rname) throws Exception;

    /**
     * 根据rid获取对应旅游线路对象
     * @param rid
     * @return
     */
    Route findRouteByRid(String rid) throws Exception;
}
