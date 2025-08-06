package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSJSController {

    
    @GetMapping("/start")
    public String redirectToPage() {
        return "redirect:/showPage";
    }


    @GetMapping("/showPage")
    public String showPage() {
        return "index"; // maps to index.jsp
    }
}