package com.engine.springbootquickstart_v2.member.controller;

import com.engine.springbootquickstart_v2.member.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String ShowLoginPage(){
        logger.info("Show login page");
        return "member/login";
    }

    @GetMapping("/error")
    public String ShowLoginErrorPage(){
        return "eroror";
    }

    @PostMapping("/member/login")
    public String Login(String id, String password, HttpSession session){
        // 작성 필요
        logger.info("Login form");
        if(loginService.authenticate(id)){
            session.setAttribute("id", id);
            session.setAttribute("password", password);
            logger.info("Login Success");
            return "redirect:/board/board";
        }else {
            logger.info("login Fail");
            return "/member/login";
        }
    }
}