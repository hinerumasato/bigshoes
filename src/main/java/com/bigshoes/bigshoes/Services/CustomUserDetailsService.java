package com.bigshoes.bigshoes.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bigshoes.bigshoes.Models.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByEmail(username);
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");

        grantList.add(grantedAuthority);
        if(userEntity != null) {
            UserDetails userDetails = new User(userEntity.getEmail(), userEntity.getPassword(), grantList);
            return userDetails;
        }
        else {
            new UsernameNotFoundException("Login Fail");
        }
        return null;
    }
    
}
