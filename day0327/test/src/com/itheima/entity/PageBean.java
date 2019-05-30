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
    private int totalCount;//总记录数

    //    起始页码
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }



    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {

        return data;
    }

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
     * @param curPage
     * @param pageSize
     * @param totalCount
     */
    public PageBean(int curPage, int pageSize, int totalCount) {
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public int getStartIndex() {
        return (this.curPage - 1) * this.pageSize;
    }

    public int getTotalPage() {
        return (int) Math.ceil(totalCount * 1.0 / pageSize);
    }


}
