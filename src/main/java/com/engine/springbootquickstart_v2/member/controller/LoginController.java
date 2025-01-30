package com.engine.springbootquickstart_v2.member.controller;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);


    @GetMapping("/")
    private String ShowLoginPage(){
        return "member/login";
    }

    @PostMapping("/login")
    private String Login(String id, String password, HttpSession session, Model model){
        // 작성 필요
        return "board/board";
    }

}
