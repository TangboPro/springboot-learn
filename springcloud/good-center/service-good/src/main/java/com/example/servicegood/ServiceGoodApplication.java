package com.example.servicegood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.example.facadegood.facade"})
//@EnableFeignClients
public class ServiceGoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGoodApplication.class, args);
    }

}
