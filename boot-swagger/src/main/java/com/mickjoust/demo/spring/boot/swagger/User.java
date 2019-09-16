package com.hjf.boot.demo.swagger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * name: com.hjf.boot.demo.swagger
 * author: mickjoust
 * date: 2018/4/24
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String phone;
    private String address;

}
