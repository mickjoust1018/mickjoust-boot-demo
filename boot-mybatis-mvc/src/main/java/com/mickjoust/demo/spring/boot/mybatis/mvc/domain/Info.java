package com.mickjoust.demo.spring.boot.mybatis.mvc.domain;

/**
 * Created by mickjoust on 2016/6/8.
 * com.hjf.boot.demo.boot_mybatis_mvc.domain
 */
public class Info {

    private Long id;
    private String name;
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
