package com.libei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan("com.libei.mapper")
@MapperScan("com.libei.mapper")
public class GradesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradesignApplication.class, args);
    }

}

