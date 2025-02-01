package com.engine.springbootquickstart_v2.board.controller;

import com.engine.springbootquickstart_v2.board.dto.Article;
import com.engine.springbootquickstart_v2.board.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // 📌 게시판 페이지
    @GetMapping("/board/board")
    public String board(Model model, HttpSession session) {
        List<Article> posts = new ArrayList<>();
        model.addAttribute("id", session.getAttribute("id"));

        Optional<List<Article>> list = boardService.getAllList();  // 🔥 게시글 리스트 가져오기
        if (list.isPresent()) {  // ✅ Optional 체크
            posts = list.get();
        }
        model.addAttribute("posts", posts);  // ✅ 모델에 게시글 리스트 추가
        return "board/board";  // ✅ Thymeleaf 뷰 반환
    }

    // 📌 게시글 작성
    @PostMapping("/board/write")
    public String write(@RequestParam String title, @RequestParam String content, HttpSession session) {
        String id = (String) session.getAttribute("id");
        String password = (String) session.getAttribute("password");

        logger.info("id : {}, password : {}", id, password);
        Article article = new Article(articleNum++, id, title, content);
        logger.info("article : {}", article);
        boardService.addArticle(article);

        return "redirect:/board/board";  // ✅ 글 작성 후 게시판으로 이동
    }

    // 📌 특정 게시글 JSON 반환 (모달에서 사용)
    @GetMapping("/board/{id}")
    @ResponseBody  // ✅ JSON 형식으로 반환
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        Optional<Article> article = boardService.getArticle(id);
        logger.info("article : {}", article.get());
        if (article.isPresent()) {
            return ResponseEntity.ok(article.get());  // ✅ 200 OK와 함께 데이터 반환
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글을 찾을 수 없습니다.");
        }
    }
}
