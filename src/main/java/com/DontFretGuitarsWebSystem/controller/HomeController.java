package com.DontFretGuitarsWebSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by danielwalker on 02/05/2016.
 */

// Controller for the home page and navbar interactions
@Controller
public class HomeController {

    // map the home page to the root application context
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    // Controller action to display the login page and validate customer login
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value = "logout",
    required = false) String logout, Model model) {

        if(error != null){
            model.addAttribute("error", "Invalid username and password");
        }

        if(logout!=null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        return "login";
    }

    // Controller action for accessing the contact page
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

}
