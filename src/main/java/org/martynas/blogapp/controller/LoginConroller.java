package org.martynas.blogapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginConroller {

    @GetMapping("/login")
    public String login(Principal principal) {
        // Just curious  what if we get username from Principal instead of SecurityContext
        if (principal != null) {
            return "redirect:/"; // if user already logged in redirect back to root context
        } else {
        // the end of curiosity //

//        // get current user from Security Context
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        if (!username.equals("anonymousUser")) {
//            return "redirect:/"; // if user already logged in redirect back to root context
//        } else {
            return "login";
        }
    }
}
