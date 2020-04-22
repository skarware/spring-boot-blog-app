package org.martynas.blogapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginConroller {

    @GetMapping("/login")
    public String login() {
        // get current user from Security Context
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!username.equals("anonymousUser")) {
            return "redirect:/"; // if user already logged in redirect back to root context
        }
        return "login";
    }
}
