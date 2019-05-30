package com.itheima.service;

import com.itheima.entity.Category;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-06-9:07
 */
public interface CategoryService {
    public List<Category> findAllCategory() throws Exception;
}
