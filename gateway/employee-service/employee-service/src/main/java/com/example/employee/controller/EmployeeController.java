package com.example.employee.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/test")
    public Map<String, String> test(@RequestHeader Map<String, String> headers) {
        return Map.of(
            "message", "Request received at Employee Service",
            "X-Request-Source", headers.getOrDefault("x-request-source", "Not Provided")
        );
    }
}
