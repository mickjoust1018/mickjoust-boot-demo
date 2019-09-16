package com.mickjoust.demo.spring.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * name: com.hjf.boot.demo.web
 * author: mickjoust
 * date: 2018/4/25
 **/
@Controller
@SpringBootApplication
public class BaseController {

    public static void main(String[] args) {
        SpringApplication.run(BaseController.class,args);
    }

    @RequestMapping(value = {"/","/index.html"})
    public String returnView(Model model){

        Man single = new Man("aa",11);

        List<Man> mans = new ArrayList<>();

        Man p1 = new Man("bb",11);
        Man p2 = new Man("cc",22);
        Man p3 = new Man("zz",33);
        mans.add(p1);
        mans.add(p2);
        mans.add(p3);

        model.addAttribute("singleMan", single);
        model.addAttribute("mans", mans);

        return "index";
    }
}
