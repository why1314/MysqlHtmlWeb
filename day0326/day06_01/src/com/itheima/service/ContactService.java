package com.itheima.service;

import com.itheima.entity.Contact;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-26-15:56
 */
public interface ContactService {

    /**
     *功能详情：查询所有账号
     *
     * @param:
     * @return List<Contact>
     * @author wz
     * @date 2019-3-26 16:53
     */
    List<Contact> findAll();

    /**
     *功能详情：添加新账号
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-26 16:53
     * @param contact
     */
    int add(Contact contact);

    /**
     *功能详情：删除选中的联系人
     *
     * @param: cids
     * @return
     * @author wz
     * @date 2019-3-26 18:16
     */
    void deleteChecked(String[] cids);

    /**
     *功能详情：
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-26 21:26
     */
    List<Contact> queryByConditions(String name, String qq);
}
