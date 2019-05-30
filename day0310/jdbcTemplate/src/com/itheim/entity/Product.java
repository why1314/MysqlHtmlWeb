package com.itheim.entity;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-10:21
 */
public class Product {
    private int id;
    private String pname;
    private double price;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product() {

    }

    public Product(int id, String pname, double price) {

        this.id = id;
        this.pname = pname;
        this.price = price;
    }
}
