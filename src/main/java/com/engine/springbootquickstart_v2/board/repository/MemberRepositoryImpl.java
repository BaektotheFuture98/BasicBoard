package com.engine.springbootquickstart_v2.board.repository;

import com.engine.springbootquickstart_v2.board.domain.Member;

import java.util.*;

public class MemberRepositoryImpl implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

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
