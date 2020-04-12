package org.martynas.blogapp.controller;

import org.martynas.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //    @ResponseBody
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String getPost(@PathVariable Long id, Model model) {

        model.addAttribute("post", postService.getById(id).get());

        return "post";
    }
}
