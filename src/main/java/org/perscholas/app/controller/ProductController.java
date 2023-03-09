package org.perscholas.app.controller;

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

    @GetMapping("/UpdateProduct/{productId}")
    public ModelAndView UpdateForm(@PathVariable (name ="productId") int productId) {
        ModelAndView mav = new ModelAndView("updateproduct");
        Product product = productRepoI.findById(productId).get();
        product.setProductName(product.getProductName());

        product.setProductPrice(product.getProductPrice());
        product.setProductSize(product.getProductSize());
        product.setProductColor(product.getProductColor());
        product.setProductQuantity(product.getProductQuantity());
        product.setProductDescription(product.getProductDescription());
        productRepoI.save(product);
        mav.addObject("product", product);

        return mav;
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

