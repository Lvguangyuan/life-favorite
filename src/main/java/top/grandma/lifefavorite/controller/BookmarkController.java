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
    private HttpServletRequest request;

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping(method = RequestMethod.POST, value = "save")
    public String save() {
        Bookmark bookmark = new Bookmark();
        bookmark.setTitle(request.getParameter("title"));
        bookmark.setLink(request.getParameter("link"));
        bookmark.setType(request.getParameter("type"));
        bookmark.setDescription(request.getParameter("description"));
        bookmarkService.save(bookmark);
        return "redirect:/bookmark";
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete")
    public String delete() {
        bookmarkService.deleteById(Integer.valueOf(request.getParameter("id")));
        return "redirect:/bookmark";
    }
}
