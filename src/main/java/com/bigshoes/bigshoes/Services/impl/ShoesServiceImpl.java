package com.bigshoes.bigshoes.Services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bigshoes.bigshoes.Models.ShoesEntity;
import com.bigshoes.bigshoes.Repositories.ShoesRepository;
import com.bigshoes.bigshoes.Repositories.impl.ShoesRepositoryImpl;
import com.bigshoes.bigshoes.Services.ShoesService;

@Service
public class ShoesServiceImpl implements ShoesService {
    private ShoesRepository shoesRepository = new ShoesRepositoryImpl();

    @Override
    public List<ShoesEntity> findAll() {
        return shoesRepository.findAll();
    }

    @Override
    public ShoesEntity findByName(String name) {
        return shoesRepository.findByName(name);
    }
    
}
