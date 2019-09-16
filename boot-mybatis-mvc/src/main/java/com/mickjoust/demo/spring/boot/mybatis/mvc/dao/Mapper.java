package com.hjf.boot.demo.boot_mybatis_mvc.dao;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by mickjoust on 2016/6/8.
 * com.hjf.boot.demo.boot_mybatis_mvc.dao
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Mapper {
    String value() default "";
}
