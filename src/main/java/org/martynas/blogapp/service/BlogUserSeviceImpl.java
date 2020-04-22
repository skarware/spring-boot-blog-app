package org.martynas.blogapp.service;

import org.martynas.blogapp.model.Authority;
import org.martynas.blogapp.model.BlogUser;
import org.martynas.blogapp.repository.AuthorityRepository;
import org.martynas.blogapp.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class BlogUserSeviceImpl implements BlogUserSevice {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private final BlogUserRepository blogUserRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public BlogUserSeviceImpl(BlogUserRepository blogUserRepository, AuthorityRepository authorityRepository) {
        this.blogUserRepository = blogUserRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<BlogUser> blogUser = blogUserRepository.findByUsername(username);
        if (blogUser.isPresent()) {
            return blogUser.get();
        } else {
            throw new UsernameNotFoundException("No user found with username " + username);
        }
//        return blogUser.orElseThrow(() -> new UsernameNotFoundException("No user found with username \" + username"));
    }

    @Override
    public Optional<BlogUser> findByUsername(String username) {
        return blogUserRepository.findByUsername(username);
    }

    @Override
    public BlogUser saveNewBlogUser(BlogUser blogUser) throws RoleNotFoundException {
        // Encode plaintext password with bcrypt password encoder
//        blogUser.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(blogUser.getPassword()));
        // Set default Authority/Role to new blog user
        Optional<Authority> optionalAuthority = authorityRepository.findByAuthority(DEFAULT_ROLE);
        if (optionalAuthority.isPresent()) {
            Authority authority = optionalAuthority.get();
            Collection<Authority> authorities = Collections.singletonList(authority);
            blogUser.setAuthorities(authorities);
//            return blogUserRepository.save(blogUser);
            return blogUserRepository.saveAndFlush(blogUser);
        } else {
            throw new RoleNotFoundException("Default role not found for blog user with username " + blogUser.getUsername());
        }
    }
}
