package com.ggomg.myshop.post.repository;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.entity.Post;
import com.ggomg.myshop.post.entity.QPost;
import com.ggomg.myshop.post.repository.PostRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final EntityManager em;

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

        JPAQueryFactory query = new JPAQueryFactory(em);
        return query
                .selectFrom(post)
                .where(post.title.eq(title)
                .or(post.content.eq(content)))
                .fetch();
    }

}