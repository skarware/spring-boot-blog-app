package org.martynas.blogapp.service;

import org.martynas.blogapp.model.Post;
import org.martynas.blogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private static final int POSTS_PER_PAGE = 3;

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Collection<Post> getAll() {
        return postRepository.findAllByOrderByCreationDateDesc();
    }

    @Override
    public Page<Post> getAllPageable(int page) {
        return postRepository.findAllByOrderByCreationDateDesc(PageRequest.of((page < 1) ? 0 : page - 1, POSTS_PER_PAGE));
    }

    @Override
    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
