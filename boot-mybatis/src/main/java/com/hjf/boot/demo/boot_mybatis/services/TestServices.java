package com.hjf.boot.demo.boot_mybatis.services;

import com.hjf.boot.demo.boot_mybatis.dao.TestDao;
import com.hjf.boot.demo.boot_mybatis.domain.TestPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hjf on 2016/5/16.
 * com.hjf.boot.demo.boot_mybatis.services
 */
@Service
public class TestServices {

    @Autowired
    private TestDao testDao;


    public String show(){
        return "hello world!";
    }

    public List<TestPOJO> showDao(int age){
        return testDao.get(age);
    }
}
