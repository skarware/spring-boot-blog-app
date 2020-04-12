package org.martynas.blogapp.service;

import org.martynas.blogapp.model.Post;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Optional<Post> getById(Long id);

    List<Post> getAll();

    Page<Post> getAllPageable(int page);

    Post save(Post post);

    void delete(Post post);
}

