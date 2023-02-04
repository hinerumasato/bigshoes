package com.bigshoes.bigshoes.Services.impl;

import org.springframework.stereotype.Service;

import com.bigshoes.bigshoes.Models.UserEntity;
import com.bigshoes.bigshoes.Repositories.UserRepository;
import com.bigshoes.bigshoes.Repositories.impl.UserRepositoryImpl;
import com.bigshoes.bigshoes.Services.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
