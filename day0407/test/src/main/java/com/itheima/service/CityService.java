package com.itheima.service;

import com.itheima.entity.City;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-20:33
 */
public interface CityService {
    /**
     * 获取当前省份下所有的城市
     * @param pid
     * @return
     */
    List<City> findCityByPid(String pid) throws Exception;
}
