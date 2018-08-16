package com.hjf.boot.demo.swagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * name: com.hjf.boot.demo.swagger
 * author: mickjoust
 * date: 2018/4/24
 * 一个简单的CRUD接口显示例子
 **/
@EnableAutoConfiguration
@RestController
@RequestMapping("/use")
@ComponentScan
public class TestController {

    public static void main(String[] args) {
        SpringApplication.run(TestController.class,args);
        //启动报错，为什么？
        //问题1：原因是因为swagger引用了jackson，使用2.9。4版本以上就可以了，2.8.x也会报错
    }

    //模拟保存用户信息
    static Map<Integer, User> users = new HashMap<>();

    static
    {
        User user1 = new User(1,"john","18012345678","cd");
        User user2 = new User(2,"marry","18012345678","bj");
        User user3 = new User(3,"jack","18012345678","sz");
        users.put(1,user1);
        users.put(2,user2);
        users.put(3,user3);
    }

    @ApiOperation(value="创建用户", notes="传一个表单数据")
    @ApiImplicitParam(name = "User", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value="获取用户", notes="根据id查询信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户", notes="根据id来指定更新对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "User", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @RequestBody User user) {
        User user$ = users.get(id);
        user$.setName(user.getName());
        users.put(id, user$);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据id删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        users.remove(id);
        return "success";
    }
}
