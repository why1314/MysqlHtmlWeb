package com.itheima.dao;

import com.itheima.entity.Province;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-20:08
 */
public interface ProvinceDao {
    /**
     * 查询所有的省份
     * @return
     */
    List<Province> findAllProvince() throws Exception;
}
