package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class FormBeanController {
	@PostMapping("/register")
    public String handleRegistration(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("birthday") String birthday,
            @RequestParam("profession") String profession,
            Model model) {

        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("birthday", birthday);
        model.addAttribute("profession", profession);

        return "SuccessForm"; // Return to JSP named SuccessForm.jsp
    }
}


