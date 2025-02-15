package com.engine.springbootquickstart_v2.member.repository;

import com.engine.springbootquickstart_v2.member.dto.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryMySQL implements MemberRepository {
    Logger logger = LoggerFactory.getLogger(MemberRepositoryMySQL.class);
    EntityManager entityManager;

    public MemberRepositoryMySQL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Member> findById(String id) {
        try {
            Member member = entityManager.createQuery("select m from Member m where m.id = :id", Member.class).setParameter("id", id).getSingleResult();
            return Optional.of(member);
        } catch (NoResultException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }


    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> member = entityManager
                .createQuery("SELECT m FROM Member m WHERE name=:name", Member.class)
                .setParameter("name", name).getResultList();

        return member.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = entityManager.createQuery("SELECT m FROM Member m", Member.class).getResultList();
        return members;
    }
}
