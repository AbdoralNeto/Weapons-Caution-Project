package com.cautela.armamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(){
        return "home"; // renderiza o arquivo home.html in templates
    }
}