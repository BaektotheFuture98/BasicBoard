package com.engine.springbootquickstart_v2.board.controller;


import com.engine.springbootquickstart_v2.board.domain.Member;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    Logger logger = LoggerFactory.getLogger(BoardController.class);

    @GetMapping("/")
    private String Login(){
        return "board/login";
    }

    @RequestMapping("/login")
    private String Login(@ModelAttribute Member member, HttpSession session, Model model) {
        String id = member.getId();
        String password = member.getPassword();
        logger.info("id : " + id);
        logger.info("password : " + password);
        model.addAttribute("id", id);
        return "board/board";
    }
}
