package kd.demoservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class GreetingController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {

        return "Hello World !";
    }
}