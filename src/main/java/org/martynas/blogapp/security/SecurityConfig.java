package org.martynas.blogapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder bcryptEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/createNewPost/**", "/editPost/**", "/comment/**").hasRole("USER")
                .antMatchers("/deletePost/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login") // same as default implicit configuration
                .usernameParameter("username") // same as default implicit configuration
                .passwordParameter("password") // same as default implicit configuration
                .defaultSuccessUrl("/")
                .failureUrl("/login?error") // same as default implicit configuration
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().sessionManagement().maximumSessions(1);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password(bcryptEncoder().encode("password")).roles("USER").and()
                .withUser("admin").password(bcryptEncoder().encode("password")).roles("USER","ADMIN");
    }

}
