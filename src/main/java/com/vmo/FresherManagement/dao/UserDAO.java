package com.vmo.FresherManagement.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vmo.FresherManagement.model.User;
import com.vmo.FresherManagement.respository.UserRepository;
import com.vmo.FresherManagement.security.CustomUserDetails;


@Service
@Transactional
public class UserDAO implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Sai tên đăng nhập");
        return new CustomUserDetails(user);
    }
}
