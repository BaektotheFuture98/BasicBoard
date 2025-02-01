package com.engine.springbootquickstart_v2.board.repository;

import com.engine.springbootquickstart_v2.board.dto.Article;

import java.util.List;
import java.util.Optional;


public interface BoardRepository {
    Article save(Article article);
    Optional<Article> findById(Long id);
    Optional<Article> findByTitle(String title);
    Optional<Article> findByContent(String content);
    Optional<List<Article>> findAll();
    void deleteById(Long id);
}
