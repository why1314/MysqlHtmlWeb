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
    /**
     *功能详情：查询所有联系人
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-27 16:20
     */
    List<Contact> findAll();

    /**
     *功能详情：添加新的联系人
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-27 16:20
     */
    int add(Contact contact);

    /**
     *功能详情：批量删除多条联系人数据
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-27 16:20
     */
    void deleteChecked(JdbcTemplate template, String[] cids);

    /**
     *功能详情：模糊查询符合条件的联系人
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-27 16:19
     */
    List<Contact> queryByConditions(String name, String qq, int curPage, int pageSize);

    /**
     *功能详情：删除指定id的联系人
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-27 16:19
     */
    int deleteById(String id);

    /**
     *功能详情：分页查询
     *
     * @param: curPage 当前页；pageSize当前页显示条数
     * @return
     * @author wz
     * @date 2019-3-27 16:18
     */
    List<Contact> queryByPage(int curPage, int pageSize);

    /**
     *功能详情：查询总条数
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-27 16:18
     */
    int findTotalCount();

    /**
     * 根据id查询联系人信息
     * @param id
     * @return
     */
    Contact findById(String id);

    void update(Contact contact);


    int findTotalCountByConditions(String name, String qq);
}
