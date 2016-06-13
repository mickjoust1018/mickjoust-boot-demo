package com.hjf.boot.demo.boot_mybatis.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mickjoust on 2016/4/13.
 * com.hjf.boot.api.config
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.14.138.191:3306/test?useUnicode=true&amp;characterEncoding=UTF-8");
        dataSource.setUsername("test");
        dataSource.setPassword("123456");
        return dataSource;
    }

}
