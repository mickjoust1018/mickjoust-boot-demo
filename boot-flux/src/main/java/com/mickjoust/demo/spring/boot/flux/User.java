package com.mickjoust.demo.spring.boot.flux;

/**
 * name: com.hjf.boot.demo.flux
 * author: mickjoust
 * date: 2018/3/12
 * 测试用户类
 **/
public class User {
    private String id;
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
