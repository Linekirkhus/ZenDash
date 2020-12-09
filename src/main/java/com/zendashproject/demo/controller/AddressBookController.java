package com.zendashproject.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class AddressBookController {


    @GetMapping("/addressbook")
    public ModelAndView showAddressBook(ModelAndView modelAndView){
        modelAndView.setViewName ( "addressbook" );
        return modelAndView;
    }

}
