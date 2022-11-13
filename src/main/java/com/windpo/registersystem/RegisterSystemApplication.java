package com.windpo.registersystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.windpo.registersystem.mapper")
@EnableTransactionManagement
public class RegisterSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterSystemApplication.class, args);
    }

}
