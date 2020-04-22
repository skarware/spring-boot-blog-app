package org.martynas.blogapp.service;

import org.martynas.blogapp.model.BlogUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.management.relation.RoleNotFoundException;
import java.util.Optional;

public interface BlogUserSevice extends UserDetailsService {

    Optional<BlogUser> findByUsername(String username);

    BlogUser saveNewBlogUser(BlogUser blogUser) throws RoleNotFoundException;

}
