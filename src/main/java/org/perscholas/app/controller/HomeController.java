package org.perscholas.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String homePage(){
        return "index";
    }
    @GetMapping("/shoes")
    public String homeShoes(){
        return "shoes.html";
    }
    @GetMapping("/hoodies")
    public String homeHoodies(){
        return "hoodies";
    }
}
