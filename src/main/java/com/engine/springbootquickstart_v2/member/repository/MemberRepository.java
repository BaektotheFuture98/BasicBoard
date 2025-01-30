package com.engine.springbootquickstart_v2.member.repository;

import com.engine.springbootquickstart_v2.member.dto.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
