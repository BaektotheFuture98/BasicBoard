package com.engine.springbootquickstart_v2;

import com.engine.springbootquickstart_v2.member.controller.LoginController;
import com.engine.springbootquickstart_v2.member.repository.MemberRepository;
import com.engine.springbootquickstart_v2.member.repository.MemberRepositoryMySQL;
import com.engine.springbootquickstart_v2.member.service.LoginService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private EntityManager em;

    @Autowired
    public BeanConfiguration(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryMySQL(em);
    }

    @Bean
    public LoginService loginService() {
        return new LoginService(memberRepository());
    }

    @Bean
    public LoginController loginController() {
        return new LoginController(loginService());
    }
}
