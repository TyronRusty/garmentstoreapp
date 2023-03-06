package org.perscholas.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping(value = {"/", "index"})
    public String homePage(Model model){
        return "index";
    }
    @GetMapping("/About")
    public String getAbout(){
        return "About";
    }
    @GetMapping("/hoodies")
    public String homeHoodies(){
        return "hoodies";
    }
    @GetMapping("/Tshirt")
    public String homeTshirt(){
        return "Tshirt";
    }
    @GetMapping("/shoes")
    public String getShoes(){
        return "shoes";
    }
    @GetMapping("/detailblackt")
    public String getDetail(){
        return "detailblackt";
    }



}
