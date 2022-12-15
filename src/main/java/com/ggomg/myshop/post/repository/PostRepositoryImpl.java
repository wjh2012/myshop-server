package com.ggomg.myshop.post.repository;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.entity.Post;
import com.ggomg.myshop.post.entity.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Override
    public void create(Post post) {
        em.persist(post);
    }

    @Override
    public Post read(Long id) {
        return em.find(Post.class, id);
    }


    @Override
    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    @Override
    public List<Post> findByMember(Member member) {
        return em.createQuery("select p from Post p where p.member =: member", Post.class)
                .setParameter("member", member)
                .getResultList();
    }

    @Override
    public List<Post> findByTitle(String title) {
        return em.createQuery("select p from Post p where p.title =: title", Post.class)
                .setParameter("title", title)
                .getResultList();
    }

    @Override
    public List<Post> findByContent(String content) {
        return em.createQuery("select p from Post p where p.content =: content", Post.class)
                .setParameter("content", content)
                .getResultList();
    }

    @Override
    public List<Post> findByTitleOrContent(String title, String content) {
        QPost post = QPost.post;

        return queryFactory
                .selectFrom(post)
                .where(post.title.eq(title)
                        .or(post.content.eq(content)))
                .fetch();
    }

}
