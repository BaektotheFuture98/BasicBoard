package com.engine.springbootquickstart_v2.member.service;

import com.engine.springbootquickstart_v2.member.dto.Member;
import com.engine.springbootquickstart_v2.member.repository.MemberRepository;
import com.engine.springbootquickstart_v2.member.repository.MemberRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    Logger logger = LoggerFactory.getLogger(LoginService.class);
    private final MemberRepositoryImpl memberRepository;

    @Autowired
    public LoginService(MemberRepositoryImpl memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean authenticate(Member member) {
        String id = member.getId();
        memberRepository.
    }
}
