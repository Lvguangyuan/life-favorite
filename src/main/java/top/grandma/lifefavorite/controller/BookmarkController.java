package top.grandma.lifefavorite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.grandma.lifefavorite.domain.Bookmark;
import top.grandma.lifefavorite.service.BookmarkService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("bin/bookmark")
public class BookmarkController {

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping(method = RequestMethod.POST, value = "save")
    public String save() {
        Bookmark bookmark = new Bookmark();
        bookmark.setTitle(req.getParameter("title"));
        bookmark.setLink(req.getParameter("link"));
        bookmark.setType(req.getParameter("type"));
        bookmark.setDescription(req.getParameter("description"));
        bookmarkService.save(bookmark);
        return "redirect:/bookmark";
    }

}
