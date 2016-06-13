package com.hjf.boot.demo.boot_mybatis;

//import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by mickjoust on 2016/5/16.
 * com.hjf.boot.demo.boot_mybatis
 */
@SpringBootApplication
//@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
//@ImportResource(locations = "classpath*:/applicationContext.xml")
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args);
    }
}
