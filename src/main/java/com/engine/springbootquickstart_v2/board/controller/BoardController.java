package com.engine.springbootquickstart_v2.board.controller;

import com.engine.springbootquickstart_v2.board.dto.Article;
import com.engine.springbootquickstart_v2.board.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {
    private final BoardService boardService;
    private static int articleNum = 0;
    Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/board/board")
    private String board(Model model, HttpSession session) {
        List<Article> posts = new ArrayList<>();
        model.addAttribute("id", session.getAttribute("id"));
        Optional<List<Article>> list = boardService.getAllList();  // 🔥 리스트 가져오기
        if (list != null) {  // 🚨 Null 체크
            posts = list.get();
        }

        model.addAttribute("posts", posts);  // ✅ 모델에 추가
        return "board/board";
    }

    @PostMapping("/board/write")
    private String wirte(@RequestParam String title, @RequestParam String content, HttpSession session) {
        String id = session.getAttribute("id").toString();
        String password = session.getAttribute("password").toString();
        logger.info("id : {}, pasword {}", id, password);
        Article article = new Article(articleNum++, id, title, content);
        boardService.addArticle(article);
        return "redirect:/board/board";
    }
}
