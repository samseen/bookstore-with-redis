package com.samseen.redis_bookstore.entity;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
public class Book implements Serializable {
    @Id
    private int id;
    private String title;
    private String isbn;
    private String pubDate;
    private String publisher;
    private String genre;
    private String description;
    private String language;
}
