package top.grandma.lifefavorite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.grandma.lifefavorite.domain.Bookmark;
import top.grandma.lifefavorite.model.BookmarkType;
import top.grandma.lifefavorite.repository.BookmarkRepository;

import java.util.*;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    public Iterable<Bookmark> findAll() {
        return bookmarkRepository.findAll();
    }

    public Iterable<Bookmark> findAllByType(String type) {
        return bookmarkRepository.findALLByType(type);
    }

    public void save(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
    }

    public void deleteById(int id) {
        bookmarkRepository.deleteById(id);
    }

    public Map<String, Iterable<Bookmark>> groupAllByType() {
        Map<String, Iterable<Bookmark>> map = new LinkedHashMap<>();
        String type;
        for (BookmarkType bookmarkType : BookmarkType.values()) {
            type = bookmarkType.getType();
            map.put(type, this.findAllByType(type));
        }
        return map;
    }

    @Transactional
    public void updateType(String newType, int id) {
        bookmarkRepository.updateType(newType, id);
    }

}
