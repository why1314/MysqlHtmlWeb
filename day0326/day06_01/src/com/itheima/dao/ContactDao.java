package com.itheima.dao;

import com.itheima.entity.Contact;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-26-15:59
 */
public interface ContactDao {
    List<Contact> findAll();

    int add(Contact contact);

    void deleteChecked(JdbcTemplate template, String[] cids);

    List<Contact> queryByConditions(String name, String qq);
}
