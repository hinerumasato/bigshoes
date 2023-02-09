package com.bigshoes.bigshoes.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigshoes.bigshoes.Models.ShoesEntity;
import com.bigshoes.bigshoes.Services.ShoesService;

@RestController
public class ShoesRestController {

    @Autowired
    private ShoesService shoesService;

    @GetMapping("/api/shoes")
    public List<ShoesEntity> getAllShoes() {
        return shoesService.findAll();
    }
}
