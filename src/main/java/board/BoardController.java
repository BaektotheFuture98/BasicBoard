package board;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    Logger logger = LoggerFactory.getLogger(BoardController.class);

    @RequestMapping("/login")
    public void Login(BoardDTO boardDTO) {
        String id = boardDTO.getId();
        String password = boardDTO.getPassword();

        logger.info("id : " + id);
        logger.info("password : " + password);

    }
}
