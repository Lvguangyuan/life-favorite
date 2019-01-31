package top.grandma.lifefavorite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.grandma.lifefavorite.domain.Bookmark;
import top.grandma.lifefavorite.repository.BookmarkRepository;

@Service
public class BookmarkService {

    @Autowired BookmarkRepository bookmarkRepository;

    public Iterable<Bookmark> findAll() {
        return bookmarkRepository.findAll();
    }

    public void save(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
    }

}
