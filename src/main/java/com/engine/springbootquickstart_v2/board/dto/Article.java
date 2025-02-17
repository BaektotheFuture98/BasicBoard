package com.engine.springbootquickstart_v2.board.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "article")
public class Article {
    @Id
    private long article_num;
    private String title;
    private String content;
    private String id;
    private String author;
    private String createdAt;
    private String imageUrl;

}
