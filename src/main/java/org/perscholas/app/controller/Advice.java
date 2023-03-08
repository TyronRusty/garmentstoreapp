package org.perscholas.app.controller;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@Controller
@Slf4j
public class Advice {

    @ExceptionHandler(Exception.class)
    public ModelAndView catchAll(Exception e) {


        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", e.getMessage());
        log.debug("Exception e.getMessage(): " + e.getMessage());


        return modelAndView;
    }
}
