package com.mickjoust.demo.spring.boot.flux.func;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

/**
 * name: com.hjf.boot.demo.flux.func
 * author: mickjoust
 * date: 2018/5/14
 **/
@Configuration
public class ManControllerFunc {

    @Autowired
    private EchoHandler echoHandler;

    @Bean
    public RouterFunction<ServerResponse> echoRouterFunction() {
        return RouterFunctions.route(GET("/echo"), echoHandler::echo);
    }

}
