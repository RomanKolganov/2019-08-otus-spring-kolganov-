package me.kolganov.springsecurityformbased.hw11.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/authors").hasAnyRole("USER", "ADMIN")
                .antMatchers("/authors/delete", "/authors/create", "/authors/edit", "/authors/update").hasRole("ADMIN")
                .antMatchers("/books").hasAnyRole("USER", "ADMIN")
                .antMatchers("/books/delete", "/books/create", "/books/edit", "/books/update").hasRole("ADMIN")
                .antMatchers("/genres").hasAnyRole("USER", "ADMIN")
                .antMatchers("/genres/delete", "/genres/create", "/genres/edit", "/genres/update").hasRole("ADMIN")
                .antMatchers("/comments").hasAnyRole("USER", "ADMIN")
                .antMatchers("/comments/edit", "/comments/update").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .and()
                .rememberMe().key("myDirtyLittleSecret")
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
