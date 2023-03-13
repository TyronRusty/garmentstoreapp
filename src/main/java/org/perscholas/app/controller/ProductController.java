package org.perscholas.app.controller;

import ch.qos.logback.core.CoreConstants;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.ImageRepoI;
import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Product;
import org.perscholas.app.service.ImageService;
import org.perscholas.app.service.MyUserService;
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

    ProductService productService;
    ProductRepoI productRepoI;
    ImageRepoI imageRepoI;
    ImageService imageService;
    MyUserService myUserService;
    MyUserRepoI myUserRepoI;
@Autowired
    public ProductController(ProductService productService, ProductRepoI productRepoI, ImageRepoI imageRepoI, ImageService imageService, MyUserService myUserService, MyUserRepoI myUserRepoI) {
        this.productService = productService;
        this.productRepoI = productRepoI;
        this.imageRepoI = imageRepoI;
        this.imageService = imageService;
        this.myUserService = myUserService;
        this.myUserRepoI = myUserRepoI;
    }

    @GetMapping("/form")
    public String userForm(Model model) {
        model.addAttribute("product", new Product());


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

//    @GetMapping("/editproduct/{productId}")
//    public String editProduct(@PathVariable("productId") int productId ,Model model) {
//        Product product = productService.findProductById(productId);
//        model.addAttribute("product",product);
//   //     model.addAttribute("pageTitle","Edit  product (Id :"+productId+")");
//       return  "from" ;
//
//
//    }

    @PostMapping("/newprocess")
    public String updateForms(@ModelAttribute ("product")Product product) {


        log.debug("===================================this is id" +product.getProductId());

        productService.createOrUpdate(product);




        return "redirect:/dashboard";
    }

    @GetMapping("/UpdateProduct/{productId}")
    public String updateForm(@PathVariable (name ="productId") int productId , Model model) {


        model.addAttribute("product",productRepoI.findById(productId));


        return "updateproduct";
    }
//   @GetMapping("/UpdateProduct/{productId}")
//    public String UpdateProducts(@PathVariable(name ="productId") int productId,Model model){
//
//    model.addAttribute("product",productRepoI.findByProductId(productId));
//    return "newpage";
//
//
//}







}

