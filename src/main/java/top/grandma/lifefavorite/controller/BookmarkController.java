package top.grandma.lifefavorite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.grandma.lifefavorite.domain.Bookmark;
import top.grandma.lifefavorite.model.BookmarkType;
import top.grandma.lifefavorite.service.BookmarkService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
        bookmark.setType(request.getParameter("type"));
        bookmark.setTitle(request.getParameter("title"));
        bookmark.setLink(request.getParameter("link"));
        bookmark.setDescription(request.getParameter("description"));
        bookmark.setCreateDate(new Date());
        bookmarkService.save(bookmark);
        return "redirect:/bookmark";
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete")
    public @ResponseBody String delete() { // @ResponseBody means the returned String is the response, not a view name.
        String deletedType = BookmarkType.DELETED.getType();
        String type = request.getParameter("type");
        int id = Integer.valueOf(request.getParameter("id"));

        if (deletedType.equals(type)) {
            bookmarkService.deleteById(id);
        } else {
            bookmarkService.updateType(deletedType, id);
        }
        return "200";
    }

}
