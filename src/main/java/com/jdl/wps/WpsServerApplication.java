package com.jdl.wps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.PrintStream;

@SpringBootApplication
@MapperScan(basePackages = "com.jdl.wps.dao")
@EnableTransactionManagement
public class WpsServerApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WpsServerApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
//        SpringApplication.run(WpsServerApplication.class, args);
    }
}
