package com.engine.springbootquickstart_v2.member.repository;

import com.engine.springbootquickstart_v2.member.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public MemberRepositoryImpl() {
        Member member = new Member();
        member.setId("seonmin");
        member.setPassword("1234");
        store.put(sequence, member);
    }

    @Override
    public Member save(Member member) {
        member.setSequecne(++sequence);
        store.put(member.getSequecne(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getId().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
