package com.itheima.service;

import com.itheima.entity.Province;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-20:05
 */
public interface ProvinceService {
    /**
     * 查询所有的省份
     * @return
     */
    List<Province> findAllProvince() throws Exception;
}
