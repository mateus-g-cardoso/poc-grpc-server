package com.mateus.cardoso.pocgrpcserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PocGrpcServerApplication {

    public static void main(String[] args) {
//        new SpringApplicationBuilder(PocGrpcServerApplication.class)
//            .web(WebApplicationType.SERVLET)
//            .run(args);
        SpringApplication.run(PocGrpcServerApplication.class, args);
    }

}
