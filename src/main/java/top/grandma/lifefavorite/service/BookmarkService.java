package top.grandma.lifefavorite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import top.grandma.lifefavorite.dao.Bookmark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookmarkService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Bookmark> findAll() {
        List<Bookmark> bookmarks = jdbcTemplate.query("select * from bookmark",
            (rs, rowNum) -> new Bookmark(rs.getInt("id"), rs.getString("title"),
                rs.getString("link"), rs.getString("description")));

        return bookmarks;
    }

    public void insert(String title, String link, String description) {
        Object[] objects = {title, link, description};
//        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//            .map(name -> name.split(" "))
//            .collect(Collectors.toList());
        List<Object[]> bookmarks = new ArrayList<>();
        bookmarks.add(objects);
        jdbcTemplate.batchUpdate("INSERT INTO bookmark (title, link, description) VALUES (?, ?, ?)", bookmarks);
    }
}
