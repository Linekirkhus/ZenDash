package com.zendashproject.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class ProfileController {

    @GetMapping("/profile")
    public ModelAndView showProfile (ModelAndView modelAndView ) {
        modelAndView.getModel ();
        modelAndView.setViewName ( "profile" );
        return modelAndView;
    }
}
