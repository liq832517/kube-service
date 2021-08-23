package com.koe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableCaching
@EnableOpenApi
@SpringBootApplication
public class KubeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(KubeServiceApplication.class, args);
    }
}

