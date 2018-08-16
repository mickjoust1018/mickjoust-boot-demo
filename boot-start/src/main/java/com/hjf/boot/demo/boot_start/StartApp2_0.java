package com.hjf.boot.demo.boot_start;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;


/**
 * name: com.hjf.boot.demo.boot_start
 * author: mickjoust
 * date: 2018/3/12
 **/
//@SpringBootApplication //融合下面三个注解
@RestController
@ComponentScan
@EnableAutoConfiguration
@Configuration
public class StartApp2_0 {
    public static void main(String[] args) {
        SpringApplication.run(StartApp2_0.class,args);
//        SpringApplication bootStrap = new SpringApplication(StartApp2_0.class);
//        bootStrap.setBanner(new Banner() {
//            @Override
//            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//                //
//            }
//        });
//        bootStrap.setBannerMode(Banner.Mode.CONSOLE);
//        bootStrap.run(args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello | spring boot 2.0";
    }

    @PostMapping("/getId/{id}")
    public String show(){
        return "Your id is :";
    }

}
