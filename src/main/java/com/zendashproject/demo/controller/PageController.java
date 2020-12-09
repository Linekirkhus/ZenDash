package com.zendashproject.demo.controller;


import com.zendashproject.demo.model.User;
import com.zendashproject.demo.service.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    MyUserDetailsService myUserService;


    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    /*
    @GetMapping("/home{id}")
    public ModelAndView showHome(@RequestParam User user, Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("user", myUserService.getUsername(id));
        modelAndView.getModel().put("greeting", "Welcome to ZenDash " + user.getFirstname() + "! ");
        return modelAndView;
    }

     */

    @GetMapping("/profile")
    public String showDash() {
        return "profile";
    }

    @GetMapping("/zendash")
    public ModelAndView myZenDash() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = myUserService.get(auth.getName());
        modelAndView.addObject("username", "Welcome " + user.getFirstname() + " " + user.getLastname());
        modelAndView.setViewName("zendash");
        return modelAndView;
    }

    @GetMapping("/403")
    ModelAndView accessDenied(ModelAndView modelAndView) {
        modelAndView.getModel().put("message", "This page is forbidden..");
        modelAndView.setViewName("message");
        return modelAndView;
    }
}
