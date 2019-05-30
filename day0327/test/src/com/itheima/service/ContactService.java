package com.itheima.service;

import com.itheima.entity.Contact;
import com.itheima.entity.PageBean;

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
    PageBean<Contact> queryByConditions(String name, String qq, int curPage, int pageSize);

    /**
     *功能详情：删除指定id的联系人
     *
     * @param: String id
     * @return int
     * @author wz
     * @date 2019-3-27 15:19
     */
    int deleteById(String id);

    /**
     *功能详情：简单分页查询
     *
     * @param: int startIndex, int pageSize
     * @return
     * @author wz
     * @date 2019-3-27 15:20
     */
    List<Contact> findByPage(int startIndex, int pageSize);

    /**
     *功能详情：
     *
     * @param: curPage 当前页；pageSize当前页显示条数
     * @return PageBean
     * @author wz
     * @date 2019-3-27 16:54
     */
    PageBean<Contact> queryByPage(int curPage, int pageSize);

    /**
     *功能详情：根据id查询联系人
     *
     * @param: id 联系人id
     * @return Contact 联系人
     * @author wz
     * @date 2019-3-27 16:54
     */
    Contact findById(String id);

    /**
     *功能详情：修改联系人信息
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-27 18:20
     */
    void update(Contact contact);
}
