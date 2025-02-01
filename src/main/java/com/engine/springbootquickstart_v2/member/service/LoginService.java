package com.engine.springbootquickstart_v2.member.service;

import com.engine.springbootquickstart_v2.member.dto.Member;
import com.engine.springbootquickstart_v2.member.repository.MemberRepository;
import com.engine.springbootquickstart_v2.member.repository.MemberRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginService {
    Logger logger = LoggerFactory.getLogger(LoginService.class);
    private final MemberRepository memberRepository;

    @Autowired
    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean authenticate(String id) {
        Optional<Member> subject = memberRepository.findById(id);
        logger.info("Authenticating user with id {}", id);
        if(subject.get().getId().equals(id)) {
            return true;
        }else {
            return false;
        }
    }
}
