package top.grandma.lifefavorite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.grandma.lifefavorite.domain.Bookmark;
import top.grandma.lifefavorite.repository.BookmarkRepository;
import top.grandma.lifefavorite.service.BookmarkService;

import java.util.List;

@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

    @Autowired BookmarkService bookmarkService;

    @RequestMapping("/")
    public String toHome() {
        return "index";
    }

    @RequestMapping("/bookmark")
    public String toTool(Model model) {
        model.addAttribute("bookmarks", bookmarkService.findAll());
        return "bookmark";
    }

    @RequestMapping("/board")
    public String toBoard() {
        return "board";
    }


}
