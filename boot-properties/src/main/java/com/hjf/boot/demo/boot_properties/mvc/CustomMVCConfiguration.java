package com.hjf.boot.demo.boot_properties.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by mickjoust on 2016/6/14.
 * com.hjf.boot.demo.boot_properties.mvc
 */
@Configuration
public class CustomMVCConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.clear(); //实验发现，不起作用
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> messageConverter : converters) {
            System.out.println(messageConverter);
        }
    }
}
