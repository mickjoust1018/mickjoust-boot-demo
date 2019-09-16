package com.hjf.boot.demo.web;

/**
 * name: com.hjf.boot.demo.web
 * author: mickjoust
 * date: 2018/4/25
 **/
public class Man {

    private String name;
    private Integer phone;

    public Man() {
    }

    public Man(String name, Integer phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
