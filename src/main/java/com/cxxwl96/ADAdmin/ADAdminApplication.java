package com.cxxwl96.ADAdmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.cxxwl96.ADAdmin.*.Mapper"})
public class ADAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ADAdminApplication.class, args);
    }

}
