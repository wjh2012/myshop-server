package com.ggomg.myshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaAuditing
public class MyshopApplication {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.setData("hello! spring!");
        String data = hello.getData();
        System.out.println("data = " + data);

        SpringApplication.run(MyshopApplication.class, args);
    }

}
