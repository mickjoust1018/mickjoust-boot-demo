package com.mickjoust.demo.spring.boot.flux.func;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * name: com.hjf.boot.demo.flux.func
 * author: mickjoust
 * date: 2018/5/14
 **/
@Component
public class ManHandler {

//    private ManReactiveRepository manReactiveRepository;//目前Spring-data-jpa并不支持，会报错,要么使用mongodb
//
//    @Autowired
//    public void UserHandlerFunctions(ManReactiveRepository manReactiveRepository) {
//        this.manReactiveRepository = manReactiveRepository;
//    }

    //
    public Mono<ServerResponse> getAllUsers(ServerRequest request)
    {
//        Flux<ManEntity> allMans = manReactiveRepository.findAll();
        Flux<ManEntity> allMans = Flux.fromArray(mockMan(10).toArray(new ManEntity[10]));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(allMans, ManEntity.class);
    }

    //
    public Mono<ServerResponse> getUserById(ServerRequest request) {
//        Mono<ManEntity> manMono = manReactiveRepository.findById(Integer.valueOf(request.pathVariable("id")));
        Mono<ManEntity> manMono = Mono.just(mockMan(1).get(0));
        Mono<ServerResponse> notFount = ServerResponse.notFound().build();
        return manMono.flatMap(user -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(fromObject(user)))
                .switchIfEmpty(notFount);
    }

    //
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<ManEntity> manMono = request.bodyToMono(ManEntity.class);
//        Mono<ManEntity> mono = manMono.flatMap(man -> manReactiveRepository.save(man));
        return ServerResponse.ok().body(manMono, ManEntity.class);
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
//        Mono<Void> mono = manReactiveRepository.deleteById(id); 删除返回void的空
        return ServerResponse.ok().build(Mono.empty());
    }

    static public List<ManEntity> mockMan(int num){
        List<ManEntity> manEntityList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            ManEntity man = new ManEntity();
            man.setId(i);
            man.setName("testname_"+i);
            man.setAge(18+i);
            manEntityList.add(man);
        }
        return manEntityList;
    }
}
