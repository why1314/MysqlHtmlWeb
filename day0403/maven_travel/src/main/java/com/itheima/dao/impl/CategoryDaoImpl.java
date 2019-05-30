package com.itheima.dao.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.entity.Category;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-06-9:17
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 功能详情：查询所有分类信息
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-4-6 14:52
     */
    @Override
    public List<Category> findAllCategory() throws Exception {

        String sql = "SELECT * FROM tab_category ORDER BY cid";
        return template.query(sql, new BeanPropertyRowMapper<>(Category.class));

    }
}
