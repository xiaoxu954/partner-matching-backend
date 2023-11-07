package com.xiaoxu.partnermatchingbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaoxu.partnermatchingbackend.mapper")
public class PartnerMatchingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartnerMatchingBackendApplication.class, args);
    }

}
