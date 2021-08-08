package com.fabianlewandowski.facebookwallclone.configuration;

import com.fabianlewandowski.facebookwallclone.service.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailServiceImp userDetailServiceImp;

    @Autowired
    public SecurityConfig(@Qualifier("userDetailServiceImp") UserDetailServiceImp userDetailServiceImp) {
        this.userDetailServiceImp = userDetailServiceImp;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(userDetailServiceImp);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/h2-console").permitAll().
                and().
                formLogin().
                and().
                logout();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
