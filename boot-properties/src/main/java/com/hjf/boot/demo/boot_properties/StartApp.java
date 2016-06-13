package com.hjf.boot.demo.boot_properties;

//import com.hjf.boot.demo.boot_starterpom.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mickjoust on 2016/6/13.
 * com.hjf.boot.demo.boot_properties
 */
@RestController
@SpringBootApplication
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args);
    }

    @RequestMapping("/show")
    public String show(){
        return  "hello world mickjoust";
    }
}
