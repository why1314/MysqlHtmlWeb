package com.itheima.service.impl;

import com.itheima.dao.RouteDao;
import com.itheima.dao.impl.RouteDaoImpl;
import com.itheima.entity.Category;
import com.itheima.entity.PageBean;
import com.itheima.entity.Route;
import com.itheima.service.RouteService;
import com.itheima.utils.BeanFactoryUtils;
import com.itheima.utils.PageUtils;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-06-10:09
 */
public class RouteServiceImpl implements RouteService {

    private RouteDao dao = (RouteDao) BeanFactoryUtils.getBean("RouteDao");

    @Override
    public Route findRouteByRid(String rid) throws Exception {

        Route route = dao.findRouteByRid(rid);

        return route;
    }

    @Override
    public PageBean<Route> findRouteByPage(int pageNumber, int pageSize, String cid, String rname) throws Exception {
//        查询总条数
        int totalCount = dao.findTotalCount(cid, rname);
//          创建pagebean对象
        PageBean<Route> pb = new PageBean<>(pageNumber, pageSize, totalCount);
//      查询当前页的线路信息
//      获得起始索引
        int startIndex = pb.getStartIndex();
        List<Route> list = dao.findRouteByPage(startIndex, pageSize, cid, rname);
//      将数据封装到pb中
        pb.setData(list);
//        计算前五后四
        int[] ints = PageUtils.pagination(pageNumber, pb.getTotalPage());
        pb.setStart(ints[0]);
        pb.setEnd(ints[1]);
        return pb;
    }
}
