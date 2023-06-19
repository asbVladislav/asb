package com.example.demo.Service.User;


import com.example.demo.Entity.Security.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

   public User findByLogin(String login){
        return userRepository.findById(login).orElse(new User());
    }



    // @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=findByLogin(s);
        if (user==null){
           throw new UsernameNotFoundException(String.format("User '%s' not found", s));
        }
        return SecurityUser.fromUser(user);
    }




}
