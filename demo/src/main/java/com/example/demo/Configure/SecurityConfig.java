 package com.example.demo.Configure;

import com.example.demo.Entity.Security.Permission;

import com.example.demo.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

 @Configuration
 @EnableWebSecurity
 public class SecurityConfig  extends WebSecurityConfigurerAdapter {
@Autowired
     private UserService userService;
     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http
                .csrf().disable()
                 .authorizeRequests()
                 //.antMatchers(HttpMethod.GET,"/").hasAnyAuthority(Permission.DEVELOPERS_READ.getPermission(), Permission.DEVELOPERS_WRITE.getPermission())

                 .antMatchers("/admin/**").hasAuthority( Permission.DEVELOPERS_WRITE.getPermission())


                .antMatchers("registraite/").permitAll()
                 .antMatchers("newUser/").permitAll()
                 .antMatchers("/").permitAll()
                 .and().formLogin()
                 //.successForwardUrl("/MainPage")
          ;
     }
     @Bean
     public DaoAuthenticationProvider daoAuthenticationProvider(){
         DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
         authenticationProvider.setPasswordEncoder(passwordEncoder());
         authenticationProvider.setUserDetailsService(userService);
         return authenticationProvider;
     }
@Bean
     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
}

//     @Override
//     public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//         auth.inMemoryAuthentication()
//                 .withUser("user")
//                 .password("1")
//                 .authorities("u")
//                 .and()
//                 .withUser("admin")
//                 .password("9")
//                 .authorities("a");
//     }
 }