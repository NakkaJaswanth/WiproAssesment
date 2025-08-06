package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionsController {

  
    @GetMapping("/example/test")
    public String redirectToTest2() {
        return "redirect:/example/test2";
    }

    
    @GetMapping("/example/test2")
    public String finalPage() {
        return "SuccessForms"; // JSP page name (SuccessForm.jsp)
    }
}