package com.mickjoust.demo.spring.boot.mybatis.domain;

/**
 * Created by mickjoust on 2016/5/16.
 * com.hjf.boot.demo.boot_mybatis.domain
 */
public class TestPOJO {
    private Long id;
    private String name;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
