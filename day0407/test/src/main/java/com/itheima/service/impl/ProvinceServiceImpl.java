package com.itheima.service.impl;

import com.itheima.dao.ProvinceDao;
import com.itheima.dao.impl.ProvinceDaoImpl;
import com.itheima.entity.Province;
import com.itheima.service.ProvinceService;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-20:05
 */
public class ProvinceServiceImpl implements ProvinceService {

    @Override
    public List<Province> findAllProvince() throws Exception {
        ProvinceDao dao = new ProvinceDaoImpl();
        return dao.findAllProvince();

    }
}
