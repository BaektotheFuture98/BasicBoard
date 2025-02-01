package com.engine.springbootquickstart_v2.board.service;

import com.engine.springbootquickstart_v2.board.dto.Article;
import com.engine.springbootquickstart_v2.board.repository.BoardRepository;
import com.engine.springbootquickstart_v2.board.repository.BoardRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void addArticle(Article article) {
        boardRepository.save(article);
    }

    public Optional<Article> getArticle(Long id) {
        return boardRepository.findById(id);
    }

    public Optional<List<Article>> getAllList(){
        return boardRepository.findAll();
    }
}
