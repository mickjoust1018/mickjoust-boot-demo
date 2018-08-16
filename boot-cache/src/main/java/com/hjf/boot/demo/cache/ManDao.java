package com.hjf.boot.demo.cache;

import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

/**
 * name: com.hjf.boot.demo.cache
 * author: mickjoust
 * date: 2018/5/4
 **/
@Mapper
public interface ManDao<T,ID> {

    void save(T t);
    void deleteById(ID id);
    T findById(ID id);

}
