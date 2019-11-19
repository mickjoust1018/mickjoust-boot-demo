package com.mickjoust.demo.spring.boot.resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.vavr.control.Try;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.function.Supplier;

/**
 * Author: huangjingfeng
 * Since:2019-09-20
 **/
@RestController
@SpringBootApplication
public class TestC {

    public static void main(String[] args) {
        //
        SpringApplication.run(TestC.class,args);
    }

    @Resource
    private BackendService backendService;

    @RequestMapping("/testRateLimiter")
    public Object testRateLimiter(){
        // Create a custom RateLimiter configuration
        RateLimiterConfig config = RateLimiterConfig.custom()
                .timeoutDuration(Duration.ofMillis(100))
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .limitForPeriod(1)
                .build();
        // Create a RateLimiter
        RateLimiter rateLimiter = RateLimiter.of("backendName", config);

        // Decorate your call to BackendService.doSomething()
        Supplier<String> restrictedSupplier = RateLimiter
                .decorateSupplier(rateLimiter, backendService::hello);

        // First call is successful
        Try<String> firstTry = Try.ofSupplier(restrictedSupplier);
//      assertThat(firstTry.isSuccess()).isTrue();

        // Second call fails, because the call was not permitted
//        Try<String> secondTry = Try.of(restrictedSupplier);
//      assertThat(secondTry.isFailure()).isTrue();
//      assertThat(secondTry.getCause()).isInstanceOf(RequestNotPermitted.class);

        return firstTry.isSuccess();

    }

    @RequestMapping("/testRateLimiter")
    public Object testRateLimiter(){

    }

    @RequestMapping("/testRateLimiter")
    public Object testRateLimiter(){

    }

}
