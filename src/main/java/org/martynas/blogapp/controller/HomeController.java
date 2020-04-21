package org.martynas.blogapp.controller;

import org.martynas.blogapp.model.Post;
import org.martynas.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Collection;

@Controller
public class HomeController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {

        Collection<Post> posts = this.postService.getAll();
        model.addAttribute("posts", posts);

        return "home";
    }
}
