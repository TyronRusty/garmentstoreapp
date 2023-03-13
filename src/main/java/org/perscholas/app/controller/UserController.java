package org.perscholas.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.MyUser;
import org.perscholas.app.models.Product;
import org.perscholas.app.models.user;
import org.perscholas.app.service.MyUserService;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class UserController {

   MyUserRepoI myUserRepoI;

   MyUserService myUserService;
   @Autowired
    public UserController(MyUserRepoI myUserRepoI, MyUserService myUserService) {
        this.myUserRepoI = myUserRepoI;
        this.myUserService = myUserService;
    }

    @GetMapping("allusers")
    public String dash(@ModelAttribute MyUser myUser, Model model){
        List<MyUser> allusers = myUserRepoI.findAll();

        // allUsers.forEach(myUser -> log.debug("url form dashboard controller: " + myUser.getImage().getUrl()));

        model.addAttribute("myUser", allusers);

        return "allusers";
    }
    @GetMapping("/userform")
    public String NewUserForm(Model model) {
        model.addAttribute("myUser", new MyUser());


        return "newuserform";
    }
//    @GetMapping("/userform")
//    public ModelAndView userform() {
//        ModelAndView mav = new ModelAndView("newnew");
//        MyUser myUser = new MyUser();
//
//        mav.addObject("myUser", myUser);
//        return mav;
//    }

//    @PostMapping("/userprocessing")
//    public String userprocessing(@ModelAttribute MyUser myUser) {
//       myUserRepoI.save(myUser);
//
//        return "redirect:/allusers";
//    }
    @PostMapping("/userprocessing")
    public String CreateUsers (@ModelAttribute("myUser") MyUser myUser ){
        log.debug("before the save, user controller" +myUser);
      myUser= myUserService.save(myUser);
      log.debug(" after save the user from the save, user controller" +myUser);





        return "redirect:/allusers";
    }

@GetMapping("/updateuser/{id}")
public  String updateuser(@PathVariable("id") int id ,Model model){
       model.addAttribute("myUser" , myUserRepoI.findById(id).get());
       return "newuserform";


}

    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") int id) throws Exception {
        log.debug("Value of the string" + String.valueOf(id));
        myUserService.deleteUser(id);
        return "redirect:/allusers";
    }
}
