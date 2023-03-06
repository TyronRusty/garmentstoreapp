package org.perscholas.app.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Product;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class PrimeController {
    ProductService productService;
    ProductRepoI productRepoI;
   @Autowired
    public PrimeController(ProductService productService, ProductRepoI productRepoI) {
        this.productService = productService;
        this.productRepoI = productRepoI;

    }
    @GetMapping("/product")
    public  String getProd(Model model){
        List<Product> product =productService.ListAll();
        model.addAttribute("product" ,product);
        return "anothertest";

    }
}
