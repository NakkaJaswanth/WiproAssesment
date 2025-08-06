package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Beanfiles.Account;

@RestController
@RequestMapping("/users")
public class PathVariablesController {

    @GetMapping("/{id}/accounts")
    public List<Account> getAccounts(
            @PathVariable String id,
            @RequestParam String type,
            @RequestParam String status) {

        System.out.println("User ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Status: " + status);

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("A101", type, status));
        accounts.add(new Account("A102", type, status));

        return accounts;
    }
}

