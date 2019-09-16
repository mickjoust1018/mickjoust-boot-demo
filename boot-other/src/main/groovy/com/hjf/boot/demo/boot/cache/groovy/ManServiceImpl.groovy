package com.hjf.boot.demo.boot.cache.groovy

import org.springframework.stereotype.Service

/**
 *
 */
@Service("manService")
class ManServiceImpl implements ManService {

    @Override
    Man getInfoByName(String name) {
        return new Man(1,name,"1233131312312")
    }
}