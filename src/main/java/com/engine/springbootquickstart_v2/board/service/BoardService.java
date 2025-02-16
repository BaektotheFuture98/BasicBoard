package com.engine.springbootquickstart_v2.board.service;

import com.engine.springbootquickstart_v2.board.dto.Article;
import com.engine.springbootquickstart_v2.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {
    Logger logger = LoggerFactory.getLogger(BoardService.class);
    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void addArticle(Article article) {
        boardRepository.save(article);
    }

    public Optional<Article> getArticle(long id) {
        logger.info("Get article by id: {}", id);
        return boardRepository.findById(id);
    }

    public Optional<List<Article>> getAllList(){
        return boardRepository.findAll();
    }
}
