package com.bigshoes.bigshoes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.bigshoes.bigshoes.Models.ShoesEntity;
import com.bigshoes.bigshoes.Services.ShoesService;


@Controller
public class RouteController {

    @Autowired
    private ShoesService shoesService;

    @GetMapping("/")
    public String goToHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "index.html";
    }

    @GetMapping("/about")
    public String about() {
        return "about.html";
    }

    @GetMapping("/product")
    public String product() {
        return "product.html";
    }

    @GetMapping("/product/{name}")
    public ModelAndView productDetails(@PathVariable("name") String shoesName) {
        ModelAndView mv = new ModelAndView("product-details.html");
        ShoesEntity shoesEntity = shoesService.findByName(shoesName);
        mv.addObject("shoes", shoesEntity);
        return mv;
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
}
