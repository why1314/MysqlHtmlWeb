package com.itheima.service;

import com.itheima.dao.StuDao;
import com.itheima.entity.Stu;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-21:17
 */
public class StuService {

    private StuDao stuDao = new StuDao();

    public List<Stu> findAll() {
        return stuDao.findAll();

    }

    public List<Stu> findByVag(String vagName) {

       return stuDao.stuDao(vagName);
    }
}
