package com.jad.JADAdmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.jad.JADAdmin"})
public class JADAdmin {

    public static void main(String[] args) {
        SpringApplication.run(JADAdmin.class, args);
    }

}
