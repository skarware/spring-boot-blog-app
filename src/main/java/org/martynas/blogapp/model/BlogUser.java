package org.martynas.blogapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", initialValue = 10, allocationSize = 1)
public class BlogUser implements UserDetails {

    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MIN_PASSWORD_LENGTH = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    private Long id;

    @NotNull
    //    @Column(name = "username", nullable = false, unique = true)
    @Length(min = MIN_USERNAME_LENGTH, message = "Username must be at least " + MIN_USERNAME_LENGTH + " characters long")
    @NotEmpty(message = "*Please provide your name")
    private String username;

    @NotNull
    @JsonIgnore // just in case
    @Length(min = MIN_PASSWORD_LENGTH, message = "Password must be at least " + MIN_PASSWORD_LENGTH + " characters long")
    @NotEmpty(message = "Please enter the password")
    private String password;

    @OneToMany(mappedBy = "user")
    private Collection<Post> posts;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Authority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
