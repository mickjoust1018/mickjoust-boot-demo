package com.mickjoust.demo.spring.boot.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * name: com.hjf.boot.demo.flux
 * author: mickjoust
 * date: 2018/3/12
 * 
 **/
@SpringBootApplication
@RestController
public class StartAppFlux {

    public static void main(String[] args) {
        SpringApplication.run(StartAppFlux.class,args);
    }

    @GetMapping("/hello_world_mono")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World with flux's mono");
    }

    @GetMapping("/hello_world_flux")
    public Flux<String> helloWorldFlux() {
        return Flux.just("Hello", "World");
    }
}
