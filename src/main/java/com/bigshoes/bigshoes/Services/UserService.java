package com.bigshoes.bigshoes.Services;
import org.springframework.stereotype.Service;

import com.bigshoes.bigshoes.Models.UserEntity;

@Service
public interface UserService {
    public UserEntity findByEmail(String email);
}
