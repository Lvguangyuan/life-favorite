package top.grandma.lifefavorite.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import top.grandma.lifefavorite.domain.Bookmark;
import top.grandma.lifefavorite.service.BookmarkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BookmarkPageServlet", urlPatterns = "/bin/add-bookmark")
public class BookmarkPageServlet extends HttpServlet {

    @Autowired BookmarkService bookmarkService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        Bookmark bookmark = new Bookmark();
        bookmark.setTitle(req.getParameter("title"));
        bookmark.setLink(req.getParameter("link"));
        bookmark.setDescription(req.getParameter("description"));
        bookmarkService.save(bookmark);

        resp.sendRedirect("/bookmark");
//        PrintWriter writer = resp.getWriter();
//        writer.println("Success");
//        writer.close();
    }
}
