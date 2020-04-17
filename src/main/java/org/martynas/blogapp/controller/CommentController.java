package org.martynas.blogapp.controller;

import org.martynas.blogapp.model.Comment;
import org.martynas.blogapp.model.Post;
import org.martynas.blogapp.service.CommentService;
import org.martynas.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@SessionAttributes("comment")
public class CommentController {

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public CommentController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/comment/{id}")
    public String showComment(@PathVariable Long id, Model model) {
        Optional<Post> postOptional = this.postService.getById(id);
        if (postOptional.isPresent()) {
            Comment comment = new Comment();
            comment.setPost(postOptional.get());
            model.addAttribute(comment);
            System.err.println("GET comment: " + comment); // for testing debugging purposes
            return "commentForm";
        } else {
            System.err.println("Could not find a post by id: " + id); // for testing debugging purposes
            return "error";
        }
    }

    @PostMapping("/comment")
    public String validateComment(@Valid @ModelAttribute Comment comment, BindingResult bindingResult, SessionStatus sessionStatus) {
        System.err.println("POST comment: " + comment); // for testing debugging purposes
        if (bindingResult.hasErrors()) {
            System.err.println("Comment did not validate");
            return "commentForm";
        }
        this.commentService.save(comment);
        System.err.println("SAVE comment: " + comment); // for testing debugging purposes
        sessionStatus.setComplete();
        return "redirect:/post/" + comment.getPost().getId();
    }

}
