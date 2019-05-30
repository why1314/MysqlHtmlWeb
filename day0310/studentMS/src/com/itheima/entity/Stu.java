package com.itheima.entity;

import java.util.Objects;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-20:20
 */
public class Stu {
    private int id;
    private String name;
    private String sex;
    private int age;

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return id == stu.id &&
                age == stu.age &&
                Objects.equals(name, stu.name) &&
                Objects.equals(sex, stu.sex);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, sex, age);
    }

    public Stu() {

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

    public Stu(int id, String name, String sex, int age) {

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
