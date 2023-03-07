package org.perscholas.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Product;
import org.perscholas.app.service.ImageService;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
    public String userForm(Model model) {
        model.addAttribute("product", new Product());
       // model.addAttribute("pageTitle","add new product");

        return "form";
    }

    @PostMapping("/processing")
    public String updateOrCreateProduct(@ModelAttribute("product") Product product, Model model, @RequestParam("file") MultipartFile file) throws Exception {
        Product fromDB = productService.createOrUpdate(product);
        model.addAttribute("product", fromDB);
        model.addAttribute("message", "success");
        imageService.save(file, fromDB.getProductName());


        return "redirect:/dashboard";
    }


    @GetMapping("/deleteproduct/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId) throws Exception {
        log.debug("Value of the string" + String.valueOf(productId));
        productService.deleteProduct(productId);
        return "redirect:/dashboard";
    }

    @GetMapping("/editproduct/{productId}")
    public String editProduct(@PathVariable("productId") int productId ,Model model) {
        Product product = productService.findProductById(productId);
        model.addAttribute("product",product);
   //     model.addAttribute("pageTitle","Edit  product (Id :"+productId+")");
       return  "from" ;


    }

    @GetMapping("/UpdateProduct")
    public ModelAndView UpdateForm(@RequestParam Integer productId) {
        ModelAndView mav = new ModelAndView("form");
        Product product = productService.findProductById(productId);
        mav.addObject("product", product);
        return mav;
    }

}

