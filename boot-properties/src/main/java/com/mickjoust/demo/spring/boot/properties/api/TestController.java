package com.mickjoust.demo.spring.boot.properties.api;

import com.mickjoust.demo.spring.boot.properties.domain.JsonResp;
import com.mickjoust.demo.spring.boot.properties.domain.TestInfoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mickjoust on 2016/6/14.
 * com.hjf.boot.demo.boot_properties.api
 */
@RestController
public class TestController {

    @Autowired
    private TestInfoSettings testInfoSettings;

    @RequestMapping("/success")
    public Object success(){
        String testStr = "hello world!";
        return JsonResp.success(testStr);
    }

    @RequestMapping("/fail")
    public Object fail(){
        return JsonResp.fail();
    }


    @RequestMapping("/showSetting")
    public Object showSetting(){
        StringBuffer sb = new StringBuffer();
        sb.append("setting name is : ").append(testInfoSettings.getName());
        sb.append("setting age is : ").append(testInfoSettings.getAge());
        sb.append("all is : ").append(testInfoSettings);
        return JsonResp.success(sb);
    }
}
