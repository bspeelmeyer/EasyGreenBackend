package com.pp1.easygreen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pp1.easygreen.mapper")
public class EasygreenApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasygreenApplication.class, args);
    }
}
