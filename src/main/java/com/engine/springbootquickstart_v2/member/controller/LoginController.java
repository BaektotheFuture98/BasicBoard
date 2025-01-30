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
    private static LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        LoginController.loginService = loginService;
    }

    @GetMapping("/")
    private String ShowLoginPage(){
        return "member/login";
    }

    @PostMapping("/login")
    private String Login(String id, String password, HttpSession session, Model model){
        // 작성 필요
        if(loginService.authenticate(id)){
            session.setAttribute("id", id);
            session.setAttribute("password", password);
            return "redirect:board/board";
        }else {
            logger.info("login Fail");
            return "redirect:/";
        }
    }

}
