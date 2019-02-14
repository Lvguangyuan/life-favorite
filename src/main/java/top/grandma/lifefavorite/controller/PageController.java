package top.grandma.lifefavorite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.grandma.lifefavorite.model.BookmarkType;
import top.grandma.lifefavorite.service.BookmarkService;

/**
 * @Controller 返回页面, @RestController返回 json 数据
 */
@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping("/")
    public String toIndex() {
        // 重定向
        return "redirect:/home";
    }

    @RequestMapping("/bookmark")
    public String toTool(Model model) {
        model.addAttribute(BookmarkType.FREQUENT.getType(), bookmarkService.findAllByType(BookmarkType.FREQUENT.getType()));
        model.addAttribute(BookmarkType.TODO.getType(), bookmarkService.findAllByType(BookmarkType.TODO.getType()));
        model.addAttribute(BookmarkType.INTEREST.getType(), bookmarkService.findAllByType(BookmarkType.INTEREST.getType()));
        model.addAttribute(BookmarkType.DEVELOP.getType(), bookmarkService.findAllByType(BookmarkType.DEVELOP.getType()));
        model.addAttribute("bookmarks", bookmarkService.findAll());
        return "bookmark";
    }

    @RequestMapping("/board")
    public String toBoard() {
        return "board";
    }

    /**
     * 静态文件默认加载目录：
     * html: resource/templates/
     * css, js: resource/static/
     */
    @RequestMapping("/home")
    public String toHome() {
        return "index";
    }


}
