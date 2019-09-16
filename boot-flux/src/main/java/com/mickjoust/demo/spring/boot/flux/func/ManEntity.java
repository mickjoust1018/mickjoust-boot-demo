package com.hjf.boot.demo.flux.func;

import javax.persistence.*;

/**
 * name: com.hjf.boot.demo.flux.func
 * author: mickjoust
 * date: 2018/5/14
 **/
@Entity
@Table(name="Man")
public class ManEntity {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

//    @Column(nullable=false)
    private String name;

//    @Column(nullable=false, unique=true)
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
