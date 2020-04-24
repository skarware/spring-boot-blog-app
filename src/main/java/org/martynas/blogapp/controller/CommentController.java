package org.martynas.blogapp.controller;

import org.martynas.blogapp.model.BlogUser;
import org.martynas.blogapp.model.Comment;
import org.martynas.blogapp.model.Post;
import org.martynas.blogapp.service.BlogUserService;
import org.martynas.blogapp.service.CommentService;
import org.martynas.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@SessionAttributes("comment")
public class CommentController {

    private final PostService postService;
    private final BlogUserService blogUserService;
    private final CommentService commentService;

    @Autowired
    public CommentController(PostService postService, BlogUserService blogUserService, CommentService commentService) {
        this.postService = postService;
        this.blogUserService = blogUserService;
        this.commentService = commentService;
    }

    @Secured("ROLE_USER")
    @GetMapping("/comment/{id}")
    public String showComment(@PathVariable Long id, Model model, Principal principal) {

        // Just curious  what if we get username from Principal instead of SecurityContext
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        // the end of curiosity //

//        // get username of current logged in session user
//        String authUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        // find user by username
        Optional<BlogUser> optionalBlogUser = this.blogUserService.findByUsername(authUsername);
        // find post by id
        Optional<Post> postOptional = this.postService.getById(id);
        // if both optionals is present set user and post to a new comment and put former in the model
        if (postOptional.isPresent() && optionalBlogUser.isPresent()) {
            Comment comment = new Comment();
            comment.setPost(postOptional.get());
            comment.setUser(optionalBlogUser.get());
            model.addAttribute("comment", comment);
            System.err.println("GET comment/{id}: " + comment + "/" + id); // for testing debugging purposes
            return "commentForm";
        } else {
            System.err.println("Could not find a post by id: " + id + " or user by logged in username: " + authUsername); // for testing debugging purposes
            return "error";
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("/comment")
    public String validateComment(@Valid @ModelAttribute Comment comment, BindingResult bindingResult, SessionStatus sessionStatus) {
        System.err.println("POST comment: " + comment); // for testing debugging purposes
        if (bindingResult.hasErrors()) {
            System.err.println("Comment did not validate");
            return "commentForm";
        } else {
            this.commentService.save(comment);
            System.err.println("SAVE comment: " + comment); // for testing debugging purposes
            sessionStatus.setComplete();
            return "redirect:/post/" + comment.getPost().getId();
        }
    }

}
