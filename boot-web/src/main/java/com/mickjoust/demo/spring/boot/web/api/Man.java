package com.hjf.boot.demo.web.api;

/**
 * name: com.hjf.boot.demo.web.api
 * author: mickjoust
 * date: 2018/4/27
 **/
public class Man {

    private String name;
    private String age;
    private String phone;

    public Man(String name, String age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
