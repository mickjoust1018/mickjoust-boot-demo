package com.mickjoust.demo.spring.boot.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * name: com.hjf.boot.demo.swagger
 * author: mickjoust
 * date: 2018/4/24
 * swagger的配置类
 **/
@Configuration
@EnableSwagger2
public class ConfigSwagger {

    @Bean
    public Docket writeRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hjf.boot.demo.swagger"))
                .paths(PathSelectors.any())
                .build();
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在Spring Boot 2中使用Swagger 2自动构建RESTful APIs文档")
                .description("示例来自：http://blog.csdn.net/mickjoust")
                .termsOfServiceUrl("")
                .contact("mickjoust")
                .version("1.0")
                .build();
    }
}

