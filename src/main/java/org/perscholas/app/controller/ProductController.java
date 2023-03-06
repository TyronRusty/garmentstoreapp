package org.perscholas.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Product;
import org.perscholas.app.service.ImageService;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ProductController {

    private final ProductRepoI productRepoI;
    private final ProductService productService;
    private final ImageService imageService;
    @Autowired
    public ProductController(ProductRepoI productRepoI, ProductService productService, ImageService imageService) {
        this.productRepoI = productRepoI;
        this.productService = productService;
        this.imageService = imageService;
    }

    @GetMapping("/form")
    public String userForm(Model model){
        model.addAttribute("product", new Product());

        return "form";
    }
    @PostMapping("/processing")
    public String updateOrCreateUser(@ModelAttribute("product")Product product, Model model, @RequestParam("file") MultipartFile file) throws Exception {
        Product fromDB = productService.createOrUpdate(product);
        model.addAttribute("product",fromDB);
        model.addAttribute("message", "success");
        imageService.save(file , fromDB.getProductName());


        return "formtest";
    }
}
