package com.engine.springbootquickstart_v2.board.dto;

import lombok.Data;

@Data
public class Article {
    private String title;
    private String content;
    private String id;
    private String author;
    private String createdAt;


    public Article() {}

    public Article(int id, String author, String title, String content) {
        this.id = Integer.toString(id);
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
