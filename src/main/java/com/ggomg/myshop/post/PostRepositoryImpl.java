package com.ggomg.myshop.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository{

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
    public List<Post> findByTitle(String title) {
        return em.createQuery("select p from Post p where p.title =: title", Post.class)
                .setParameter("title", title)
                .getResultList();
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }
}
