package com.samseen.redis_bookstore.repository;

import com.samseen.redis_bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    public static final String HASH_KEY = "Book";
    @Autowired
    private RedisTemplate template;

    public Book save(Book book) {
        template.opsForHash().put(HASH_KEY, book.getId(), book);
        return book;
    }

    public List<Book> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Book findBookById(int id) {
        return (Book) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteBook(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Book Removed";
    }
}
