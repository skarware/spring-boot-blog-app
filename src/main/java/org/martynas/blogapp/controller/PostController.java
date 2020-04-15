package org.martynas.blogapp.controller;

import org.martynas.blogapp.model.Comment;
import org.martynas.blogapp.service.CommentService;
import org.martynas.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
    }

    //    @ResponseBody
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String getPost(@PathVariable Long id, Model model) {
//        Comment comment = new Comment();
        model.addAttribute("post", this.postService.getById(id).get());
//        model.addAttribute("comment", comment);

        return "post";
    }
}
