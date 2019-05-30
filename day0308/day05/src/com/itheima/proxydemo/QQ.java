package com.itheima.proxydemo;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-08-14:57
 */
public class QQ implements Car {
    @Override
    public void run() {
        System.out.println("qq以每秒1米向前移动");
    }

    @Override
    public void color() {
        System.out.println("中国红");
    }

    @Override
    public String jiaYou(String you) {

        return "您加的油是"+you;
    }
}
