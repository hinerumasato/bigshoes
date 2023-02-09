package com.bigshoes.bigshoes.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bigshoes.bigshoes.Models.ShoesEntity;

@Service
public interface ShoesService {
    public List<ShoesEntity> findAll();
    public ShoesEntity findByName(String name);
}
