package com.itheima.service.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.impl.CategoryDaoImpl;
import com.itheima.entity.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.BeanFactoryUtils;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-06-9:07
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao dao = (CategoryDao) BeanFactoryUtils.getBean("CategoryDao");

    @Override
    public List<Category> findAllCategory() throws Exception {
        return dao.findAllCategory();
    }
}
