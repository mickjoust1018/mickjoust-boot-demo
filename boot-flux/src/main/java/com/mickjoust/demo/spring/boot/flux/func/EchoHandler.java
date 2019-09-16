package com.mickjoust.demo.spring.boot.flux.func;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * name: com.hjf.boot.demo.flux.func
 * author: mickjoust
 * date: 2018/5/14
 **/
@Component
public class EchoHandler {

    public Mono<ServerResponse> echo(ServerRequest request) {
        return ServerResponse.ok().body(fromObject(request.queryParam("name")));
    }

}
