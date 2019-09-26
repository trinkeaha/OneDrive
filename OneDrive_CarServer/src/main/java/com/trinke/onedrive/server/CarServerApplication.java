package com.trinke.onedrive.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.trinke.onedrive.server.dao")
@EnableDiscoveryClient
public class CarServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarServerApplication.class,args);
    }
}
