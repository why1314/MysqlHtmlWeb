package com.itheima.dao.impl;

import com.itheima.dao.CityDao;
import com.itheima.entity.City;
import com.itheima.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-20:36
 */
public class CityDaoImpl implements CityDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<City> findCityByPid(String pid) throws Exception {
        String sql = "SELECT * FROM city WHERE pid=?";
        List<City> list = template.query(sql, new BeanPropertyRowMapper<City>(City.class), pid);
        return list;
    }
}
