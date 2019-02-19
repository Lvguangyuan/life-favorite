package top.grandma.lifefavorite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.grandma.lifefavorite.domain.Bookmark;
import top.grandma.lifefavorite.model.BookmarkType;
import top.grandma.lifefavorite.service.BookmarkService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("bin/bookmark")
public class BookmarkController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping(method = RequestMethod.POST, value = "save")
    public void save() {
        Bookmark bookmark = new Bookmark();
        bookmark.setType(request.getParameter("type"));
        bookmark.setTitle(request.getParameter("title"));
        bookmark.setLink(request.getParameter("link"));
        bookmark.setDescription(request.getParameter("description"));
        bookmarkService.save(bookmark);
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete")
    public void delete() {
        String deletedType = BookmarkType.DELETED.getType();
        String type = request.getParameter("type");
        int id = Integer.valueOf(request.getParameter("id"));

        if (deletedType.equals(type)) {
            bookmarkService.deleteById(id);
        } else {
            Bookmark bookmark = new Bookmark();
            bookmark.setId(id);
            bookmark.setType(deletedType);
            bookmarkService.save(bookmark);
        }
    }

}
