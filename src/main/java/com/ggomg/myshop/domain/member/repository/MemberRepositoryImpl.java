package com.ggomg.myshop.domain.member.repository;

import com.ggomg.myshop.domain.member.entity.Member;
import com.ggomg.myshop.member.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

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

        return queryFactory
                .selectFrom(member)
                .where(
                        member.email.eq(email),
                        member.password.eq(password))
                .fetch();
    }

}
