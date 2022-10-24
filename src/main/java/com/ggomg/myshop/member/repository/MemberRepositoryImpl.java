package com.ggomg.myshop.member.repository;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.member.entity.QMember;
import com.ggomg.myshop.member.repository.MemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;

    @Override
    public void create(Member member) {
        em.persist(member);
    }

    @Override
    public Member read(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public List<Member> findByEmailAndPassword(String email, String password) {
        QMember member = QMember.member;

        JPAQueryFactory query = new JPAQueryFactory(em);
        return query
                .select(member)
                .from(member)
                .where(
                        (member.email.eq(email))
                                .and(member.password.eq(password)))
                .fetch();
    }


}
