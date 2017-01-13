package blah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yubodiwu on 1/13/17.
 */
@EnableAutoConfiguration
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String hello() {
        return "Hello World!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
}
