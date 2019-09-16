package com.mickjoust.demo.spring.boot.echarts;


import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: mickjoust
 * Since:2019-08-23
 *
 * 本地图表可视化
 **/
@RestController
@SpringBootApplication
public class LocalChart {

    public static void main(String[] args) {
        SpringApplication.run(LocalChart.class,args);
    }

    @RequestMapping("/localchart")
    public ModelAndView localChart(){
        //构造模板引擎
        ModelAndView model = new ModelAndView();
        User user = new User("蔬菜列表",new String[]{"土豆", "番茄", "白菜", "芹菜"});
        model.addObject(user);
        model.setViewName("localchart");
        return model;
    }

    @RequestMapping(value = "/getJsonData")
    public String getjsondata(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("123",123);
        Tree root = new Tree();
        List<Tree> rootChildren = new ArrayList<Tree>();
        root.setName("知识体系");
        root.setChildren(rootChildren);

        Tree root11 =new Tree("技能1");
        Tree root12 =new Tree("能力1");
        Tree root13 =new Tree("知识1");

        rootChildren.add(root11);
        rootChildren.add(root12);
        rootChildren.add(root13);

        List<Tree> pointList11 = new ArrayList<Tree>();
        List<Tree> pointList12 = new ArrayList<Tree>();
        List<Tree> pointList13 = new ArrayList<Tree>();

        for (int i = 0; i < 20; i++) {
            pointList11.add(new Tree("专业技能",111111+i));
        }
        for(int i = 0; i < 20; i++) {
            pointList12.add(new Tree("通用能力",222222+i));
        }
        for(int i = 0; i < 20; i++) {
            pointList13.add(new Tree("领域知识",333333));
        }
        root11.setChildren(pointList11);
        root12.setChildren(pointList12);
        root13.setChildren(pointList13);

        return JSON.toJSONString(root);
    }


    @Getter
    @Setter
    @NoArgsConstructor
    class Tree {

        private String name;
        private List<Tree> children;
        private Object value;

        public Tree(String name) {
            this.name = name;
        }

        public Tree(String name, Object value) {
            this.name = name;
            this.value = value;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class User {

        private String name;
        private String[] array;

    }
}
