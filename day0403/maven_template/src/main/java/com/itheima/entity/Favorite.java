package com.itheima.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * 收藏实体类
 */
public class Favorite implements Serializable {
    private Integer rid;
    private Integer uid;
    private String date;//收藏时间

    private Route route;//旅游线路对象
    private User user;//所属用户


    @Override
    public String toString() {
        return "Favorite{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", date='" + date + '\'' +
                ", route=" + route +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return Objects.equals(rid, favorite.rid) &&
                Objects.equals(uid, favorite.uid) &&
                Objects.equals(date, favorite.date) &&
                Objects.equals(route, favorite.route) &&
                Objects.equals(user, favorite.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rid, uid, date, route, user);
    }

    public Integer getRid() {

        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Favorite() {

    }

    public Favorite(Integer rid, Integer uid, String date, Route route, User user) {

        this.rid = rid;
        this.uid = uid;
        this.date = date;
        this.route = route;
        this.user = user;
    }
}
