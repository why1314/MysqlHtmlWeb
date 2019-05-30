package com.itheima.dao.impl;

import com.itheima.dao.ContactDao;
import com.itheima.entity.Contact;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
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
        try {
            String sql = " INSERT INTO contact VALUES(NULL,?,?,?,?,?,?) ";
            int insert = template.update(sql, contact.getName(), contact.getSex(), contact.getAge(), contact.getAddress(), contact.getQq(), contact.getEmail());
            return insert;
        } catch (DataAccessException e) {
            return 0;
        }
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
    public List<Contact> queryByConditions(String name, String qq, int curPage, int pageSize) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(" select * from contact where 1=1 ");
            ArrayList<String> arrayList = new ArrayList<>();
            if (name != null && name.trim().length() > 0) {
                builder.append(" AND name like \"")
                        .append('%' + name + '%')
                        .append("\" ");
//                arrayList.add("%" + name + "%");
            }
            if (qq != null && qq.trim().length() > 0) {
                builder.append(" AND qq like \"")
                        .append('%' + qq + '%')
                        .append("\" ");
//                arrayList.add("%" + qq + "%");
            }
            builder.append(" limit ?,?");


            List<Contact> list = template.query(builder.toString(), new BeanPropertyRowMapper<>(Contact.class), curPage, pageSize/*, arrayList.toArray()*/);

            return list;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(String id) {
        String sql = " delete from contact where id=? ";

        return template.update(sql, id);
    }

    @Override
    public List<Contact> queryByPage(int curPage, int pageSize) {
        try {
            String sql = "select * from contact limit ?,?";
            return template.query(sql, new BeanPropertyRowMapper<>(Contact.class), (curPage - 1) * pageSize, pageSize);
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public int findTotalCount() {
        try {
            String sql = " select count(*) from contact";
            return template.queryForObject(sql, int.class);
        } catch (DataAccessException e) {
            return 0;
        }

    }

    @Override
    public Contact findById(String id) {
        try {
            String sql = "select * from contact where id=?";

            Contact contact = template.queryForObject(sql, new BeanPropertyRowMapper<Contact>(Contact.class), id);
            return contact;
        } catch (DataAccessException e) {
            return null;
        }
    }


    @Override
    public int findTotalCountByConditions(String name, String qq) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(" select count(*) from contact where 1=1 ");
            ArrayList<String> arrayList = new ArrayList<>();
            if (name != null && name.trim().length() > 0) {
                builder.append(" AND name like \"")
                        .append('%' + name + '%')
                        .append("\" ");
//                arrayList.add("%" + name + "%");
            }
            if (qq != null && qq.trim().length() > 0) {
                builder.append(" AND qq like \"")
                        .append('%' + qq + '%')
                        .append("\" ");
//                arrayList.add("%" + qq + "%");
            }

            Integer totalCount = template.queryForObject(builder.toString(), int.class/*, arrayList.toArray()*/);

            return totalCount;
        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public void update(Contact contact) {
        try {
            String sql = "update contact set name=?,sex=?,age=?,address=?,qq=?,email=? where id=?";
            template.update(sql, contact.getName(), contact.getSex(), contact.getAge(), contact.getAddress(), contact.getQq(), contact.getEmail(), contact.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
