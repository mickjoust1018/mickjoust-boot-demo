package com.hjf.boot.demo.boot_properties.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by mickjoust on 2016/6/16.
 * com.hjf.boot.demo.boot_properties.domain
 */
@Component
@ConfigurationProperties(
        prefix = "usetest",
        locations = "classpath:config/app.properties"
)
public class TestInfoSettings {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
