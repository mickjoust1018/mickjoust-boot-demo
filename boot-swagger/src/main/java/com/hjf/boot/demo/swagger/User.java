package com.hjf.boot.demo.swagger;

/**
 * name: com.hjf.boot.demo.swagger
 * author: mickjoust
 * date: 2018/4/24
 **/
public class User {

    private int id;

    private String name;
    private String phone;
    private String address;

    public User() {
    }

    public User(int id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
