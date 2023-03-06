package org.perscholas.app.controller;

import ch.qos.logback.core.CoreConstants;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Product;
import org.perscholas.app.models.user;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class TestController {

    @Autowired
    ProductRepoI productRepoI;
    ProductService productService;


    // get map for test only
   @GetMapping("/tested")
    public String getTested(Model model){
       List<Product>productList =productRepoI.findAll();
       model.addAttribute("products" , productList);
        return "anothertest";
    }

    // get map for test only

  /*  @GetMapping("/detailblackt")
    public String gettestor(Model model){
        model.addAttribute("product" ,new Product());
        List<String>sizeList = Arrays.asList("small" , "medium" ,"large","extra large");
        model.addAttribute("SizeList", sizeList);
        List<String>ColorList = Arrays.asList("black","white","beige","gray");
        model.addAttribute("ColorList",ColorList);
        return "detailblackt";
    }*/
   /* @PostMapping("/handlesubmit")
        public String handleSubmit(Product product){
        System.out.println(product);
        productList.add(product);
        return "testor";
    }*/
    @GetMapping("/register")
    public String showForm(Model model) {
        user user = new user();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);
        List<String>colorList =Arrays.asList("black", "beige", "white");
        model.addAttribute("colorList",colorList);

        return "try";
    }
    @PostMapping("/submition")
    public String submitForm(@ModelAttribute("user")  user user) {
        System.out.println(user);
        return "redirect:/success";
    }

}
