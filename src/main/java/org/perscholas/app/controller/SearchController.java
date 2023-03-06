package org.perscholas.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.models.Product;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class SearchController {

   @GetMapping("/search")
   public String search(@RequestParam("keyword") String keyword,Model model) {
       if (keyword != null) {
           if (keyword.contains("shirt") || keyword.contains("tshirt") || keyword.contains("top")) {
               // Redirect to T-shirt page
               return "redirect:/Tshirt";
           } else if (keyword.contains("hood") || keyword.contains("hoodie") || keyword.contains("hoody")) {
               // Redirect to Hoodie page
               return "redirect:/hoodies";
           } else if (keyword.contains("sho") || keyword.contains("shoe") || keyword.contains("shoes") || keyword.contains("sneakers")) {
               // Redirect to Shoes page
               return "redirect:/shoes";
           } else {
               model.addAttribute("keyword" , keyword);
               model.addAttribute("pageTitle" ,"search results for '" +keyword+"'");
               return "search_result";
           }
       }
       return "search_result";
   }

}
