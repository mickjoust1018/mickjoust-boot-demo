package com.hjf.boot.demo.flux.webFlux;

import com.hjf.boot.demo.flux.Man;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

/**
 * name: com.hjf.boot.demo.flux.webFlux
 * author: mickjoust
 * date: 2018/5/3
 **/
public class UserControllerTest {
    private final WebTestClient client = WebTestClient
            .bindToServer()
            .baseUrl("http://localhost:8080").build();

    @Test
    public void testCreateUser() throws Exception {
        final Man man = new Man();
        man.setName("Test");
        client.post().uri("/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(man), Man.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("name").isEqualTo("Test");
    }
}
