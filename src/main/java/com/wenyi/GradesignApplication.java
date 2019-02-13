package com.wenyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan("com.baizhi.mapper")
@MapperScan("com.wenyi.mapper")
public class GradesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradesignApplication.class, args);
    }

}

