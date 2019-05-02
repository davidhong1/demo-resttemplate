package com.yuan.demoresttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoResttemplateApplication.class, args);
    }

}
