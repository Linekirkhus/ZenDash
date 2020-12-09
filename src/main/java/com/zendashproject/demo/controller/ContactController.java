package com.zendashproject.demo.controller;

import com.zendashproject.demo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


public class ContactController {

    @GetMapping("/contact")
    public ModelAndView showContact(ModelAndView modelAndView){
        modelAndView.setViewName ( "contact" );
        return modelAndView;
    }

	@GetMapping("/addcontact")
	public ModelAndView addContact(ModelAndView modelAndView){
		modelAndView.addObject ( "contact", new Person() );
		modelAndView.setViewName ( "contact" );
		return modelAndView;
	}
}
