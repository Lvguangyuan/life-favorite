package top.grandma.lifefavorite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/tool")
    public String hello() {
        return "tool";
    }


}
