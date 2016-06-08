package com.hjf.boot.demo.boot_mybatis_mvc.controller;

import com.hjf.boot.demo.boot_mybatis_mvc.dao.ShowDao;
import com.hjf.boot.demo.boot_mybatis_mvc.domain.Info;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mickjoust on 2016/6/8.
 * com.hjf.boot.demo.boot_mybatis_mvc
 */
@Controller
public class ShowController {

    @Resource
    private ShowDao showDao;

    @RequestMapping(value = {"/","/index","/index.do","/index.action"})
    public String index() {
        return "page/index";
    }

    @RequestMapping(value = "/show",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Info> show(Integer age) {
        System.out.println("test");
        return showDao.findByAge(age);
    }

}
