package com.samseen.redis_bookstore.controller;

import com.samseen.redis_bookstore.entity.Book;
import com.samseen.redis_bookstore.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDao dao;

    @PostMapping
    public Book save(@RequestBody Book book) {
        return dao.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) {
        return dao.findBookById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return dao.deleteBook(id);
    }
}
