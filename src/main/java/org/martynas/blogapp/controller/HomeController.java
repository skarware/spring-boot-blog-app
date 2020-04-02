package org.martynas.blogapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(ModelMap model) {
        model.addAttribute("testas", "vienas");
        model.addAttribute("testas2", "du");
        return "home";
    }
}
