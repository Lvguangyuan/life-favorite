package top.grandma.lifefavorite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HelloWorldController {


    /**
     * This method will return index page to user.
     * @param no arguments
     * @return index page
     */
    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }


}
