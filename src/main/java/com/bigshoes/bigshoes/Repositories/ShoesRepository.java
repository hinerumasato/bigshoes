package com.bigshoes.bigshoes.Repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigshoes.bigshoes.Models.ShoesEntity;

@Repository
public interface ShoesRepository {
    public List<ShoesEntity> findAll();
    public ShoesEntity findByName(String name);
}
