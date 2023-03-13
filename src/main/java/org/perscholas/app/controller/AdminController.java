package org.perscholas.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.dao.ImageRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.MyUser;
import org.perscholas.app.models.Product;
import org.perscholas.app.service.MyUserService;
import org.perscholas.app.service.ImageService;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@Slf4j
@SessionAttributes(value = {"userLoggedIn"})
public class AdminController {
    ProductService productService;
    ProductRepoI productRepoI;
    ImageRepoI imageRepoI;
    ImageService imageService;
    MyUserService myUserService;
    MyUserRepoI myUserRepoI;
    @Autowired
    public AdminController(ProductService productService, ProductRepoI productRepoI, ImageRepoI imageRepoI, ImageService imageService, MyUserService myUserService, MyUserRepoI myUserRepoI) {
        this.productService = productService;
        this.productRepoI = productRepoI;
        this.imageRepoI = imageRepoI;
        this.imageService = imageService;
        this.myUserService = myUserService;
        this.myUserRepoI = myUserRepoI;
    }


    @GetMapping("dashboard")
    public String dash(@ModelAttribute Product product, Model model){
        List<Product> allProducts = productRepoI.findAll();

        // allUsers.forEach(myUser -> log.debug("url form dashboard controller: " + myUser.getImage().getUrl()));

        model.addAttribute("product", allProducts);

        return "allproducts";
    }



    @GetMapping("MyUser")
    public String SeeCustomer(Model model){
        List<MyUser> allMyUsers = myUserRepoI.findAll();

        // allUsers.forEach(myUser -> log.debug("url form dashboard controller: " + myUser.getImage().getUrl()));

        model.addAttribute("user", allMyUsers);

        return "allMyUsers";
    }


}
