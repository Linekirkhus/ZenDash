package com.zendashproject.demo.controller;


import com.zendashproject.demo.model.User;
import com.zendashproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


   // @Value("${message.invalid.user}")
   // private String invalidUserMessage;

   // @Value("${message.email.error}")
  //  private String emailError;


  //  @Value("${message.registration.success}")
   // private String registrationSuccessMessage;

   // @Value("${message.login.success}")
   // private String loginWelcome;

 //   @Value("${message.logout.success}")
//    private String logoutSuccessMessage;




    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        User user = new User();
        modelAndView.getModel().put("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    //create user
    @PostMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, @ModelAttribute(value = "user") @Valid User user, BindingResult result) throws InterruptedException {

        User exists = userService.findByEmail(user.getEmail());
        if (exists != null) {
            result.rejectValue("email", "This email address is already in use..");
        }
        if (result.hasErrors()) {
            modelAndView.setViewName("register");
        } else {

            userService.register(user);
            modelAndView.addObject("message", "Congratulations! You have successfully registered a ZenDash account..");
            modelAndView.addObject("user", new User());
            user.setEnabled(true);
            userService.save(user);
        }

        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }


    @RequestMapping("/logout")
    public String logout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("message", "You have been logged out..");
        return "redirect:/";
    }
}
