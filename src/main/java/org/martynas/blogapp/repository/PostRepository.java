package org.martynas.blogapp.repository;

import org.martynas.blogapp.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByCreationDateDesc();

    Page<Post> findAllByOrderByCreationDateDesc(Pageable pageable);

    Optional<Post> findById(Long id);
}
