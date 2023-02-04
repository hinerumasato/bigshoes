package com.bigshoes.bigshoes.Repositories.impl;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bigshoes.bigshoes.Configs.JdbcConfig;
import com.bigshoes.bigshoes.Models.UserEntity;
import com.bigshoes.bigshoes.Repositories.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public UserEntity findByEmail(String email) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class)) {
            JdbcTemplate t = context.getBean("jdbcTemplate", JdbcTemplate.class);
            String query = "SELECT * FROM USER WHERE EMAIL = ?";
            List<UserEntity> listResult = t.query(query, (rs, i) -> {
                UserEntity user = new UserEntity();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getNString("name"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
                return user;
            }, email);
            return listResult.get(0);
        } catch (BeansException | DataAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
