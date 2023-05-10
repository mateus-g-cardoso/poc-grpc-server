package com.mateus.cardoso.pocgrpcserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication(scanBasePackages = {"com.mateus.cardoso.pocgrpcserver", "com.mateus.cardoso.core.services"})
@EntityScan(basePackages = "com.mateus.cardoso.core.domain")
public class PocGrpcServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocGrpcServerApplication.class, args);
    }

}
