package top.grandma.lifefavorite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HelloWorldController {


    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }


}
