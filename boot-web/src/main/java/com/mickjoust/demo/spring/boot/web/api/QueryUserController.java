package com.mickjoust.demo.spring.boot.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * name: com.hjf.boot.demo.web.api
 * author: mickjoust
 * date: 2018/4/27
 *
 **/
@RestController
@SpringBootApplication
public class QueryUserController {

    public static void main(String[] args) {
        SpringApplication.run(QueryUserController.class,args);
    }

    @Autowired
    private QueryUserService queryUserService;

    @RequestMapping("/query1")
    public List<Man> getUsers(){
        return queryUserService.query();
    }

    @RequestMapping("/query2")
    public Map<String,Object> getUsersExt(){
        Map<String,Object> resultMap = new HashMap<>();
        if (null != queryUserService.query()
                || !queryUserService.query().isEmpty()){
            resultMap.put("code",0);
            resultMap.put("msg","sucess");
            resultMap.put("data",queryUserService.query());
        } else {
            resultMap.put("code",1);
            resultMap.put("msg","error");
            resultMap.put("data","");
        }
        return resultMap;
    }

    @RequestMapping("/query3")
    public ApiResponse<List<Man>> getUsers3(){
        return ApiResponse.success(queryUserService.query());
    }
}
