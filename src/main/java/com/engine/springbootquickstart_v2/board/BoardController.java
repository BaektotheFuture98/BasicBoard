package com.engine.springbootquickstart_v2.board;


import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class BoardController {
    Logger logger = LoggerFactory.getLogger(BoardController.class);

    @GetMapping("/")
    private String Login(){
        return "board/login";
    }

    @RequestMapping("/login")
    private String Login(@ModelAttribute BoardDTO boardDTO, HttpSession session) {
        String id = boardDTO.getId();
        String password = boardDTO.getPassword();

        logger.info("id : " + id);
        logger.info("password : " + password);

        session.setAttribute("id", id);
        session.setAttribute("password", password);

        return "board/board";
    }

    @RequestMapping("/board")
    private void Board(Model model){

    }
}
