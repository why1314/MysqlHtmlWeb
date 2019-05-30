package com.itheima.dao;

import com.itheima.entity.Category;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-06-9:17
 */
public interface CategoryDao {
    List<Category> findAllCategory() throws Exception;
}
