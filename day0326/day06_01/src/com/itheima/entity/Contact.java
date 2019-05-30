package com.itheima.entity;

import java.util.Objects;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-26-15:51
 */
public class Contact {
    private int id; //id账号
    private String name;//姓名
    private String sex;//性别
    private int age;//年龄
    private String address;//籍贯
    private String qq;//qq
    private String email;//邮箱

    public Contact(int id, String name, String sex, int age, String address, String qq, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                age == contact.age &&
                Objects.equals(name, contact.name) &&
                Objects.equals(sex, contact.sex) &&
                Objects.equals(address, contact.address) &&
                Objects.equals(qq, contact.qq) &&
                Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, sex, age, address, qq, email);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact() {

    }
}
