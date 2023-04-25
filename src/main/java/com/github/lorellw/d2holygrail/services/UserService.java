package com.github.lorellw.d2holygrail.services;

import com.github.lorellw.d2holygrail.entities.Role;
import com.github.lorellw.d2holygrail.entities.User;
import com.github.lorellw.d2holygrail.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public boolean addUser(User user){
        if (userRepository.findByUsername(user.getUsername()) != null){
            return false;
        }
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
