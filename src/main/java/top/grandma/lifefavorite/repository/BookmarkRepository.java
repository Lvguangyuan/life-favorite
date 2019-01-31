package top.grandma.lifefavorite.repository;

import org.springframework.data.repository.CrudRepository;
import top.grandma.lifefavorite.domain.Bookmark;

// This will be AUTO IMPLEMENTED by Spring into a bean called bookmarkRepository
// CRUD refers create, read, update, delete
public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {

}
