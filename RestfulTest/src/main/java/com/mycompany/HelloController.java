package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;

/**
 * Created by yubodiwu on 1/11/17.
 */
@EnableAutoConfiguration
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello World!!";
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String greetings(@RequestBody String name) {
        System.out.println("route hit");
        System.out.println(name);
        return "Hello " + name;
    }
}
