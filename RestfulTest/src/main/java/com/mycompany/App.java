package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by yubodiwu on 1/11/17.
 */
@EnableAutoConfiguration
@ComponentScan("com.mycompany")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
