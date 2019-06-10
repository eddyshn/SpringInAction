package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //in memory user store
        auth
            .inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
            .withUser("admin")
            .password(new BCryptPasswordEncoder().encode("123"))
            .authorities("ROLE_USER")
            .and()
            .withUser("woody")
            .password(new BCryptPasswordEncoder().encode("bullseye"))
            .authorities("ROLE_USER");

//        super.configure(auth);
    }
}
