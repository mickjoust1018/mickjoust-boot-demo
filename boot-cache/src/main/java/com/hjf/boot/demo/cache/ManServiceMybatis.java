package com.hjf.boot.demo.cache;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * name: com.hjf.boot.demo.cache
 * author: mickjoust
 * date: 2018/5/4
 *
 **/
@Service
public class ManServiceMybatis {

    @Autowired
    private ManDao<Man,Integer> manDao;

    @CachePut(value = "man",key="#man.id") //1 
    public Man save(Man man) {
        manDao.save(man);//不需要单独添加，直接映射到对象里的id
        System.out.println("为id、key为:"+man.getId()+"数据做了缓存");
        return man;
    }

    @CacheEvict(value = "man") //2 
    public void remove(int id) {
        System.out.println("删除了id、key为"+id+"的数据缓存");
        manDao.deleteById(id);
    }

    @Cacheable(value="man",key="#man.id") //3 
    public Man findOne(Man man) {
        Man manr = manDao.findById(man.getId());
        System.out.println("为id、key为:"+manr.getId()+"数据做了缓存");
        return Optional.of(manr).orElse(null);
    }

}
