package com.example10.controller;

import com.example10.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cust")
public class UserController {

    @GetMapping("/save")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "custForm";  // looks for templates/custForm.html
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return "custForm";
        }

        model.addAttribute("message", "User saved successfully");
        return "result";
    }
}