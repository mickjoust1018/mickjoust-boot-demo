package com.mickjoust.demo.spring.boot.resilience4j;

import org.springframework.stereotype.Service;

/**
 * Author: huangjingfeng
 * Since:2019-09-20
 **/
@Service
public class BackendServiceImpl implements BackendService{


    @Override
    public String hello() {
        return "Hello world";
    }
}
