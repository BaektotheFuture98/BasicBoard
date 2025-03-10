package com.engine.springbootquickstart_v2.member.controller;

import com.engine.springbootquickstart_v2.member.dto.Member;
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
        return "/member/loginPage";
    }

    @PostMapping("/member/loginPage")
    public String Login(Member member, HttpSession session){
        try{
            String id = member.getId();
            String name = member.getName();

            if(loginService.authenticate(id)){
                session.setAttribute("id", id);
                session.setAttribute("name", name);
                logger.info("Login Success");
                return "redirect:/board/board";
            }else {
                logger.info("login Fail");
                return "redirect:/";
            }
        }catch (Exception e){
            logger.info("login Fail");
            return "redirect:/";
        }
    }
}