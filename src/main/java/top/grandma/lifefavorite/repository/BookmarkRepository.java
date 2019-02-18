package top.grandma.lifefavorite.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import top.grandma.lifefavorite.domain.Bookmark;

// This will be AUTO IMPLEMENTED by Spring into a bean called bookmarkRepository
// CRUD refers create, read, update, delete
public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {


    /**
     * 1. 默认为 hql 语句，@nativeQuery 使用 sql 语句
     * 2. 两种方式传参：
     *      a. 位置参数
     *      b. 关键字参数
     * 3. 注意类名为 "Bookmark"，必须匹配
     * 4. 若要写实现类，不必实现该接口
     * 5. Spring Data JPA tutorial: https://www.petrikainulainen.net/spring-data-jpa-tutorial/
     */
    @Query("select b from Bookmark b where b.type = ?1")
    Iterable<Bookmark> findALLByType(String type);

//    void deleteById90
}
