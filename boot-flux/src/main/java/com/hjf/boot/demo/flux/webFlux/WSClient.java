package com.hjf.boot.demo.flux.webFlux;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.time.Duration;

/**
 * name: com.hjf.boot.demo.flux.client
 * author: mickjoust
 * date: 2018/3/12
 *
 **/
public class WSClient {

    public static void main(final String[] args) {
        final WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(URI.create("ws://localhost:8080/echo"), session ->
                session.send(Flux.just(session.textMessage("Hello")))
                        .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                        .doOnNext(System.out::println)
                        .then())
                .block(Duration.ofMillis(5000));//报错Exception in thread "main" reactor.ipc.netty.http.client.HttpClientException: HTTP request failed with code: 406.
    }

}
