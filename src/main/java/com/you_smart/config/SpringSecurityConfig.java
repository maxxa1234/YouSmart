package com.you_smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/greeting","/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .defaultSuccessUrl("/index")
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .rememberMe();
    }

    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.email, u.password, 1 from users u" + " where u.email=?")
                .authoritiesByUsernameQuery("SELECT u.email, u.role, 1 from users u" + " where u.email=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);

    }
}
