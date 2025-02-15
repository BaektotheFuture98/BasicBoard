package com.engine.springbootquickstart_v2.member.service;

import com.engine.springbootquickstart_v2.member.dto.Member;
import com.engine.springbootquickstart_v2.member.repository.MemberRepository;
import com.engine.springbootquickstart_v2.member.repository.MemberRepositoryImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Transactional
public class LoginService {
    Logger logger = LoggerFactory.getLogger(LoginService.class);
    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean authenticate(String id) {
        Optional<Member> subject = memberRepository.findById(id);
        if(subject.get().getId().equals(id)) {
            return true;
        }else {
            return false;
        }
    }
}
