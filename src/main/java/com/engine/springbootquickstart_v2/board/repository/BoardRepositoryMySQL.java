package com.engine.springbootquickstart_v2.board.repository;

import com.engine.springbootquickstart_v2.board.dto.Article;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoardRepositoryMySQL implements BoardRepository {
    EntityManager entityManager;

    public BoardRepositoryMySQL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Article save(Article article) {
        entityManager.persist(article);
        return null;
    }

    @Override
    public Optional<Article> findById(long id) {
        System.out.printf("id : " + id);
        Article article = entityManager.createQuery("SELECT a FROM article a WHERE a.article_num = :id", Article.class).setParameter("id", id).getSingleResult();
        System.out.printf("article : " + article);
        return Optional.of(article);
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
        return Optional.of(entityManager.createQuery("SELECT a FROM article a").getResultList());
    }

    @Override
    public void deleteById(Long id) {

    }
}
