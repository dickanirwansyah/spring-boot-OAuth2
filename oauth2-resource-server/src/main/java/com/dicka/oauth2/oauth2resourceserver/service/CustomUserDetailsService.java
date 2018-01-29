package com.dicka.oauth2.oauth2resourceserver.service;

import com.dicka.oauth2.oauth2resourceserver.model.CustomUserDetails;
import com.dicka.oauth2.oauth2resourceserver.model.Users;
import com.dicka.oauth2.oauth2resourceserver.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UsersRepository usersRepository;

    @Autowired
    public CustomUserDetailsService(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptional = usersRepository.findByName(username);
        usersOptional
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return usersOptional.map(users -> new CustomUserDetails(users))
                .get();
    }
}
