package com.bigshoes.bigshoes.Services.impl;

import org.springframework.stereotype.Service;

import com.bigshoes.bigshoes.Models.UserEntity;
import com.bigshoes.bigshoes.Services.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Override
    public UserEntity findByEmail(String email) {
        return new UserEntity(1, "thangloitran406@gmail.com", "{noop}135792468jK", null, null, true, null);
    }
}
