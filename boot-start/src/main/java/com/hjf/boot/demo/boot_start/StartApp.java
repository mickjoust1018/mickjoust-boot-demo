package com.hjf.boot.demo.boot_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hjf on 2016/6/7.
 * com.hjf.boot.demo.boot_start
 */
@EnableAutoConfiguration
@ComponentScan
@RestController
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello world!";
    }
}
