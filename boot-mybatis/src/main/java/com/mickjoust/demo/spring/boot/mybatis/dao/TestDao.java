package com.mickjoust.demo.spring.boot.mybatis.dao;

import com.mickjoust.demo.spring.boot.mybatis.domain.TestPOJO;
//import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mickjoust on 2016/5/16.
 * com.hjf.boot.demo.boot_mybatis.dao
 */
@Mapper
public interface TestDao {

    //根据age查找info
    List<TestPOJO> get(int age);

}
