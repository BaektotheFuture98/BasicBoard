package com.engine.springbootquickstart_v2;

import com.engine.springbootquickstart_v2.member.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootQuickStartV2ApplicationTests {

    LoginService loginService;

    @Test
    void contextLoads() {
        loginService.authenticate("seonmin");
    }

}
