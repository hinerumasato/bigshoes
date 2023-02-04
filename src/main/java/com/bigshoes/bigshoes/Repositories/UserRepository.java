package com.bigshoes.bigshoes.Repositories;

import com.bigshoes.bigshoes.Models.UserEntity;

public interface UserRepository {
    public UserEntity findByEmail(String email);
}
