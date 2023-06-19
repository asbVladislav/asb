 package Vlad.IT.by.posts.configs;

import Vlad.IT.by.posts.models.Permission;
import Vlad.IT.by.posts.service.user.UserService;
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
                 .antMatchers("/MainPage/OnlyForAdmins/{ID}/**").hasAuthority( Permission.DEVELOPERS_WRITE.getPermission())
                 .antMatchers("/MainPage/EnterUser/**").hasAuthority( Permission.DEVELOPERS_WRITE.getPermission())
                 .antMatchers("/MainPage/Complete/**").hasAuthority( Permission.DEVELOPERS_WRITE.getPermission())
                 .antMatchers("/MainPage/Fail/**").hasAuthority( Permission.DEVELOPERS_WRITE.getPermission())
                 .antMatchers("/MainPage/CreateNewAdmin/**").hasAuthority( Permission.DEVELOPERS_WRITE.getPermission())

                 .antMatchers(HttpMethod.POST,"/MainPage/**").hasAnyAuthority(Permission.DEVELOPERS_READ.getPermission(), Permission.DEVELOPERS_WRITE.getPermission())
                 .antMatchers(HttpMethod.GET,"/MainPage/**").hasAnyAuthority(Permission.DEVELOPERS_READ.getPermission(), Permission.DEVELOPERS_WRITE.getPermission())
                 .antMatchers("registraite/").permitAll()
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