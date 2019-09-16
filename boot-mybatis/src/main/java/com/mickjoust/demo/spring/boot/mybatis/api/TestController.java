package com.mickjoust.demo.spring.boot.mybatis.api;

import com.mickjoust.demo.spring.boot.mybatis.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mickjoust on 2016/5/16.
 * com.hjf.boot.demo.boot_mybatis.api
 */
@RestController
public class TestController {

    @Autowired
    private TestServices testServices;

    @RequestMapping(value = "/show")
    public String show(){
        return testServices.show();
    }

    @RequestMapping(value = "/showDao")
    public Object showDao(int age){
        return testServices.showDao(age);
    }

}
