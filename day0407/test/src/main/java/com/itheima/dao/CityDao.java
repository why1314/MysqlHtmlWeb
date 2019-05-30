package com.itheima.dao;

import com.itheima.entity.City;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-20:36
 */
public interface CityDao {
    /**
     * 获取当前省份下所有城市数据
     * @param pid
     * @return
     */
    List<City> findCityByPid(String pid) throws Exception;
}
