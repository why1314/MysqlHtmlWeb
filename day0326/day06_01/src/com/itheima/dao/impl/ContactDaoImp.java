package com.itheima.dao.impl;

import com.itheima.dao.ContactDao;
import com.itheima.entity.Contact;
import com.itheima.utils.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-26-15:59
 */
public class ContactDaoImp implements ContactDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Contact> findAll() {
        try {
            String sql = " SELECT * FROM contact ";
            List<Contact> list = template.query(sql, new BeanPropertyRowMapper<>(Contact.class));
            return list;
        } catch (DataAccessException e) {
            return null;
        }


    }

    @Override
    public int add(Contact contact) {
        String sql = " INSERT INTO contact VALUES(NULL,?,?,?,?,?,?) ";
        int insert = template.update(sql, contact.getName(), contact.getSex(), contact.getAge(), contact.getAddress(), contact.getQq(), contact.getEmail());
        return insert;
    }

    @Override
    public void deleteChecked(JdbcTemplate template, String[] cids) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(" delete from contact ")
                    .append(" where id in( ");
            for (int i = 0; i < cids.length; i++) {
                if (i == cids.length - 1) {
                    builder.append(cids[i]);
                } else {
                    builder.append(cids[i]).append(",");
                }
            }
            builder.append(" ) ");

            template.update(builder.toString());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Contact> queryByConditions(String name, String qq) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(" select * from contact where 1=1 ");
            if (name != null && name.trim().length() > 0) {
                builder.append(" AND name like ?");
            }
            if (qq != null && qq.trim().length() > 0) {
                builder.append(" or qq like ?");
            }
            List<Contact> list = template.query(builder.toString(), new BeanPropertyRowMapper<>(Contact.class), '%' + name + '%', '%' + qq + '%');

            return list;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
