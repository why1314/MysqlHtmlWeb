package com.itheima.service.impl;

import com.itheima.dao.CityDao;
import com.itheima.dao.impl.CityDaoImpl;
import com.itheima.entity.City;
import com.itheima.service.CityService;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-20:33
 */
public class CityServiceImpl implements CityService {

    @Override
    public List<City> findCityByPid(String pid) throws Exception {
        CityDao dao = new CityDaoImpl();

        return dao.findCityByPid(pid);
    }
}
