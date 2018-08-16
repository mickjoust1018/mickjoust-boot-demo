package com.hjf.boot.demo.flux.webFlux;

import com.hjf.boot.demo.flux.Man;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * name: com.hjf.boot.demo.flux.webFlux
 * author: mickjoust
 * date: 2018/4/28
 **/
@Service
public class QueryUserServices {

    private final Map<String, Man> data = new ConcurrentHashMap<>();

    @PostConstruct
    void init(){
        Man man1 = new Man("1","mickjoust",66,"21313123132");
        Man man2 = new Man("2","mia",66,"21313123132");
        Man man3 = new Man("3","max",66,"21313123132");

        data.put(man1.getId(),man1);
        data.put(man2.getId(),man2);
        data.put(man3.getId(),man3);
    }

    Flux<Man> list() {
        return Flux.fromIterable(this.data.values());
    }

    Flux<Man> getById(final Flux<String> ids) {
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }

    Mono<Man> getById(final String id) {
        return Mono.justOrEmpty(this.data.get(id))
                .switchIfEmpty(Mono.error(new RuntimeException()));
    }

    Flux<Man> createOrUpdate(final Flux<Man> mans) {
        return mans.doOnNext(man -> this.data.put(man.getId(), man));
    }

    Mono<Man> createOrUpdate(final Man man) {
        this.data.put(man.getId(), man);
        return Mono.just(man);
    }

    Mono<Man> delete(final String id) {
        return Mono.justOrEmpty(this.data.remove(id));
    }
}
