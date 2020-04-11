package org.martynas.blogapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

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
}
