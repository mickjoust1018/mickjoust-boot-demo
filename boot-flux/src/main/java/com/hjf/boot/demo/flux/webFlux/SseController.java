package com.hjf.boot.demo.flux.webFlux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

/**
 * name: com.hjf.boot.demo.flux
 * author: mickjoust
 * date: 2018/3/12
 * 服务器推送事件
 **/
@Controller
@SpringBootApplication
public class SseController {

    public static void main(String[] args) {
        SpringApplication.run(SseController.class,args);
    }

    @GetMapping("/randomNumbers")
    public Flux<ServerSentEvent<Integer>> randomNumbers() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                .map(data -> ServerSentEvent.<Integer>builder()
                        .event("random")
                        .id(Long.toString(data.getT1()))
                        .data(data.getT2())
                        .build());
    }

}
