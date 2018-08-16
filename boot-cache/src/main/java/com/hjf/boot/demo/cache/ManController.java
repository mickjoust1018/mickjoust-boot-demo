package com.hjf.boot.demo.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * name: com.hjf.boot.demo.cache
 * author: mickjoust
 * date: 2018/5/4
 **/
@SpringBootApplication
@RestController
@EnableCaching
public class ManController {

    @Autowired
    private ManServiceMybatis manService;

    public static void main(String[] args) {
        SpringApplication.run(ManController.class,args);
    }

    @RequestMapping("/save/{values}")//类似mickjoust,22,123131
    public Man put(@PathVariable("values") String mockString){
        String[] str = mockString.split("[,]");
        Man m = new Man();
        m.setName(str[0]);
        m.setAge(Integer.valueOf(str[1]));
        m.setPhone(str[2]);
        return manService.save(m);
    }

    @RequestMapping("/{id}")
    public Man cacheable(@PathVariable("id") int id){
        Man man = new Man();
        man.setId(id);
        return manService.findOne(man);
    }

    @RequestMapping("/evit/{id}")
    public String evit(@PathVariable("id") int id){
        manService.remove(id);
        return "ok";
    }
}
