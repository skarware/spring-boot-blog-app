package org.martynas.blogapp.controller;

import org.martynas.blogapp.model.BlogUser;
import org.martynas.blogapp.repository.AuthorityRepository;
import org.martynas.blogapp.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

@Controller
@SessionAttributes("blogUser")
public class SignupController {

    private final BlogUserService blogUserService;

    public SignupController(BlogUserService blogUserService) {
        this.blogUserService = blogUserService;
    }

    @GetMapping("/signup")
    public String getRegisterForm(Model model) {
        BlogUser blogUser = new BlogUser();
        model.addAttribute("blogUser", blogUser);
        return "registerForm";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute BlogUser blogUser, BindingResult bindingResult, SessionStatus sessionStatus) throws RoleNotFoundException {
        System.err.println("newUser: " + blogUser);  // for testing debugging purposes
        if (bindingResult.hasErrors()) {
            System.err.println("New user did not validate");
            return "registerForm";
        }
        // persist new blog user
        this.blogUserService.saveNewBlogUser(blogUser);
        // Create Authentication token and login after registering new blog user
        Authentication auth = new UsernamePasswordAuthenticationToken(blogUser, blogUser.getPassword(), blogUser.getAuthorities());
        System.err.println("AuthToken: " + auth);
        SecurityContextHolder.getContext().setAuthentication(auth);
        System.err.println("SecurityContext Principal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
