package com.bigshoes.bigshoes.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RouteController {

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
    public ModelAndView productDetails(@PathVariable("name") String productName) {
        ModelAndView mv = new ModelAndView("product-details.html");
        mv.addObject("productName", productName);
        return mv;
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
}
