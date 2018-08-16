//package com.hjf.boot.demo.cache;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
///**
// * name: com.hjf.boot.demo.cache
// * author: mickjoust
// * date: 2018/5/4
// **/
//@Service
//public class ManService {
//
//    @Autowired
//    private ManRepository manRepository;
//
//    @CachePut(value = "man",key="#man.id") //1 
//    public Man save(Man man) {
//        Man m = (Man)manRepository.save(man);
//        System.out.println("为id、key为:"+m.getId()+"数据做了缓存");
//        return m;
//    }
//
//    @CacheEvict(value = "man") //2 
//    public void remove(Long id) {
//        System.out.println("删除了id、key为"+id+"的数据缓存");
//        manRepository.deleteById(id);
//    }
//
//    @Cacheable(value="man",key="#man.id") //3 
//    public Man findOne(Man man) {
//        Optional<Man> m = manRepository.findById(man.getId());
//        System.out.println("为id、key为:"+m.get().getId()+"数据做了缓存");
//        return m.orElse(null);
//    }
//
//}
