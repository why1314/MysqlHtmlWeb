package com.itheima.entity;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-26-22:58
 */
public class PageBean<T> {
    private List<T> data;//当前页数据，需要通过limit查询
    private int curPage;//当前页，已知数据，从页面传递
    private int totalPage;//总页数，查询
    private int pageSize;//每页显示条数，从页面传递
    private int count;//总记录数

    /**
     * @param curPage
     * @param pageSize
     */
    public PageBean(int curPage, int pageSize) {
        this.curPage = curPage;
        this.pageSize = pageSize;
    }

    /**
     *
     * @return
     */
    public int getStartIndex() {
        return (this.curPage - 1) * this.pageSize;
    }

    public int getTotalPage() {
        return (int) Math.ceil(count * 1.0 / pageSize);
    }
}
