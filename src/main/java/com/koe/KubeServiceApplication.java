package com.koe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class KubeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(KubeServiceApplication.class, args);
    }
}

