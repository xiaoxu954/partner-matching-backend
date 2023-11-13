package com.xiaoxu.partnermatchingbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.xiaoxu.partnermatchingbackend.mapper")
@EnableScheduling //定时任务支持
public class PartnerMatchingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartnerMatchingBackendApplication.class, args);
    }

}
