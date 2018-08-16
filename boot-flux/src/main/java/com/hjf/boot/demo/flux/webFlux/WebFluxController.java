package com.hjf.boot.demo.flux.webFlux;

import com.hjf.boot.demo.flux.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Objects;

/**
 * name: com.hjf.boot.demo.flux.webFlux
 * author: mickjoust
 * date: 2018/4/28
 **/
@RestController
@RequestMapping("/")
@SpringBootApplication
public class WebFluxController {

    @Autowired
    private QueryUserServices queryUserServices;

    public static void main(String[] args) {
        SpringApplication.run(WebFluxController.class,args);
    }

    @GetMapping("/get_flux")
    public Flux<Man> getFlux(){
        return queryUserServices.list();
    }

    @GetMapping("/get_flux_ids/{ids}")
    public Flux<Man> getFluxById(@PathVariable("ids") final String idStr){
        //逗号隔开，模拟，实际可以直接传post请求
        String[] testStr = idStr.split(",");
        Flux<String> ids = Flux.fromArray(testStr);
        return queryUserServices.getById(ids);
    }

    @GetMapping("/get_mono/{id}")
    public Mono<Man> getMono(@PathVariable("id") final String id){
        return queryUserServices.getById(id);
    }

    @PostMapping("/create_flux")
    public Flux<Man> createFlux(@RequestBody final Flux<Man>  mans){
        return queryUserServices.createOrUpdate(mans);
    }

    @PostMapping("/update_mono/{id}")
    public Mono<Man> updateMono(@PathVariable("id") final String id, @RequestBody final Man man){
        Objects.requireNonNull(man);
        man.setId(id);
        return queryUserServices.createOrUpdate(man);
    }

    @GetMapping("/delete_mono/{id}")
    public Mono<Man> delete(@PathVariable("id") final String id){
        return queryUserServices.delete(id);
    }


}
