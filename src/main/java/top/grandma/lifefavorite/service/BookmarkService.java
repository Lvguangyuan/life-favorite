package top.grandma.lifefavorite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.grandma.lifefavorite.domain.Bookmark;
import top.grandma.lifefavorite.repository.BookmarkRepository;

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

}
