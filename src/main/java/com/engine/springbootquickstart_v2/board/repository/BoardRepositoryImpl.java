package com.engine.springbootquickstart_v2.board.repository;


import com.engine.springbootquickstart_v2.board.dto.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    ArrayList<Article> articles = new ArrayList<>();

    @Override
    public Article save(Article article) {
        articles.add(article);
        return null;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Article> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Optional<Article> findByContent(String content) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Article>> findAll() {
        return Optional.ofNullable(this.articles);
    }

    @Override
    public void deleteById(Long id) {

    }
}
