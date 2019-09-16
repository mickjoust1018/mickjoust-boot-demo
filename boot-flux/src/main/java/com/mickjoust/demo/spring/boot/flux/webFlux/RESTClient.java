package com.mickjoust.demo.spring.boot.flux.webFlux;

import com.mickjoust.demo.spring.boot.flux.Man;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * name: com.hjf.boot.demo.flux.client
 * author: mickjoust
 * date: 2018/3/12
 * 代码还有问题
 **/
public class RESTClient {
    public static void main(final String[] args) {
        Man man = new Man();
        man.setId("11");
        man.setAge(33);
        man.setName("Test");
        man.setPhone("1232312313");
        WebClient client = WebClient.create("http://localhost:8080/create_flux");
        Flux<Man> createdUser = client.post()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(man), Man.class)
                .exchange()
                .flatMapMany(response -> response.bodyToFlux(Man.class));
        System.out.println(createdUser.blockFirst());
        //会报错Exception in thread "main" java.lang.NoClassDefFoundError: reactor/core/CoreSubscriber
    }
}
