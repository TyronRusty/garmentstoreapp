package org.perscholas.app.controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.models.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@Slf4j
public class Advice {
private final MyUserRepoI myUserRepoI;

    public Advice(MyUserRepoI myUserRepoI) {
        this.myUserRepoI = myUserRepoI;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView catchAll(Exception e) {


        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", e.getMessage());
        log.debug("Exception e.getMessage(): " + e.getMessage());


        return modelAndView;
    }
    @ModelAttribute
    public void loggedInUser(Model model, HttpServletRequest request, HttpSession http){
        Principal p = request.getUserPrincipal();

        MyUser myUser = null;
        if(p != null){
            myUser =  myUserRepoI.findByEmail(p.getName()).get();
            http.setAttribute("userLoggedIn", myUser);
            log.warn("advice controller: session attr user is in advice controller  " + myUser.getEmail());

        } else {
            log.warn("Advice controller: the principal was null");
        }
    }
}
