package com.hjf.boot.demo.flux.webFlux;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * name: com.hjf.boot.demo.flux
 * author: mickjoust
 * date: 2018/3/12
 * WebSocket
 **/
@Component
public class EchoHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(final WebSocketSession session) {
        return session.send(
                session.receive()
                        .map(msg -> session.textMessage("ECHO -> " + msg.getPayloadAsText())));
    }

}
