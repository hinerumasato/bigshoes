package com.bigshoes.bigshoes.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
}
