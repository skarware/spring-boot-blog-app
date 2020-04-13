package org.martynas.blogapp.controller;

import org.martynas.blogapp.model.Post;
import org.martynas.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelMap model) {
//        model.addAttribute("testas", "vienas");
//        model.addAttribute("testas2", "du");
//        return "home";
//
String testas = "laabas";
String testas2 = "laaaaaabas";
        ModelAndView mav = new ModelAndView("home");
        mav.addObject(testas);
        mav.addObject("testas2");

        return mav;
    }

    @GetMapping("/testas")
    @ResponseBody
    public String testas() {
        Optional<Post> post = postService.getById(2L);
        return post.get().toString();
    }
}
