package com.itheima;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-18-21:33
 */
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student() {

    }

    public Student(String name, int age, String sex) {

        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private int age;
    private String sex;
}
