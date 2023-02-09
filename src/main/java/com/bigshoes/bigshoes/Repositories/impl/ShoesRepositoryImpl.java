package com.bigshoes.bigshoes.Repositories.impl;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bigshoes.bigshoes.Configs.JdbcConfig;
import com.bigshoes.bigshoes.Models.ShoesEntity;
import com.bigshoes.bigshoes.Repositories.ShoesRepository;
import com.bigshoes.bigshoes.Utils.MyStringUtils;

@Repository
public class ShoesRepositoryImpl implements ShoesRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ShoesEntity> findAll() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class)) {
            this.jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
            String query = "SELECT * FROM SHOES";
            List<ShoesEntity> result = this.jdbcTemplate.query(query, (rs, i) -> {
                ShoesEntity shoes = new ShoesEntity();
                shoes.setId(rs.getInt("id"));
                shoes.setName(rs.getNString("name"));
                shoes.setAmount(rs.getInt("amount"));
                shoes.setImage(rs.getNString("image"));
                shoes.setPrice(rs.getDouble("price"));
                return shoes;
            });
            return result;
        }
        catch (BeansException | DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ShoesEntity findByName(String name) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class)) {
            this.jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
            String query = "SELECT * FROM SHOES WHERE UPPER(NAME) = ?";
            List<ShoesEntity> result = this.jdbcTemplate.query(query, (rs, i) -> {
                ShoesEntity shoes = new ShoesEntity();
                shoes.setId(rs.getInt("id"));
                shoes.setName(rs.getNString("name"));
                shoes.setAmount(rs.getInt("amount"));
                shoes.setImage(rs.getNString("image"));
                shoes.setPrice(rs.getDouble("price"));
                return shoes;
            }, MyStringUtils.slugToContent(name.toUpperCase()));
            return result.get(0);
        }
        catch (BeansException | DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
