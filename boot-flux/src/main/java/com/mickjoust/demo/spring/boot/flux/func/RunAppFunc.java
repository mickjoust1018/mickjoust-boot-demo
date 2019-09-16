package com.hjf.boot.demo.flux.func;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * name: com.hjf.boot.demo.flux.func
 * author: mickjoust
 * date: 2018/5/14
 **/
@SpringBootApplication
public class RunAppFunc {

    public static void main(String[] args) {
        SpringApplication.run(RunAppFunc.class,args);
    }

    @Autowired
    ManHandler manHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunctions() {
        return nest(path("/api/mans"),
                        nest(accept(APPLICATION_JSON),
                                route(GET("/{id}"), manHandler::getUserById)
                                        .andRoute(method(HttpMethod.GET), manHandler::getAllUsers)
                                        .andRoute(DELETE("/{id}"), manHandler::deleteUser)
                                        .andRoute(POST("/"), manHandler::saveUser)));
    }

}
