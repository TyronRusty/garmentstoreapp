package org.perscholas.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.CartItemRepoI;
import org.perscholas.app.dao.CustomerRepoI;
import org.perscholas.app.dao.ImageRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Product;
import org.perscholas.app.service.CustomerService;
import org.perscholas.app.service.ImageService;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class AdminController {
    ProductService productService;
    ProductRepoI productRepoI;
    ImageRepoI imageRepoI;
    ImageService imageService;
    CustomerService customerService;
    CustomerRepoI customerRepoI;
    @Autowired
    public AdminController(ProductService productService, ProductRepoI productRepoI, ImageRepoI imageRepoI, ImageService imageService, CustomerService customerService, CustomerRepoI customerRepoI) {
        this.productService = productService;
        this.productRepoI = productRepoI;
        this.imageRepoI = imageRepoI;
        this.imageService = imageService;
        this.customerService = customerService;
        this.customerRepoI = customerRepoI;
    }
    @GetMapping("/products")
    public String listAll(Model model){


        List<Product> productList = productRepoI.findAll();
        model.addAttribute("product" , productList);
        return "tested";
    }

    @GetMapping("dashboard")
    public String dash(Model model){
        List<Product> allProducts = productRepoI.findAll();

        // allUsers.forEach(myUser -> log.debug("url form dashboard controller: " + myUser.getImage().getUrl()));

        model.addAttribute("product", allProducts);




        return "allproducts";
    }

}
