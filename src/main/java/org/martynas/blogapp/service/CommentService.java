package org.martynas.blogapp.service;

import org.martynas.blogapp.model.Comment;

public interface CommentService {

    Comment save(Comment comment);

    void delete(Comment comment);

}
