package com.example.museumapp.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class OrderRecord {
    @Index(unique = true)
    private String user_id;
    private String username;
    private String time;
    private String phone;
    private String count;
    @Generated(hash = 580885467)
    public OrderRecord(String user_id, String username, String time, String phone,
            String count) {
        this.user_id = user_id;
        this.username = username;
        this.time = time;
        this.phone = phone;
        this.count = count;
    }
    @Generated(hash = 1055615028)
    public OrderRecord() {
    }
    public String getUser_id() {
        return this.user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCount() {
        return this.count;
    }
    public void setCount(String count) {
        this.count = count;
    }

}
