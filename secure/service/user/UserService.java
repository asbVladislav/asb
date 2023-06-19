package Vlad.IT.by.posts.service.user;

import Vlad.IT.by.posts.models.user;
import Vlad.IT.by.posts.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private userRepository usRep;

   public user findByLogin(String login){
        return usRep.findByLogin(login).orElse(new user());
    }



    // @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        user user=findByLogin(s);
        if (user==null){
           throw new UsernameNotFoundException(String.format("User '%s' not found", s));
        }
        return SecurityUser.fromUser(user);
    }




}
