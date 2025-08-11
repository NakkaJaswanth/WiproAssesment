package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AccountDTO;
import com.service.KafkaProducerService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final KafkaProducerService producerService;

    public AccountController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody AccountDTO account) throws Exception {
        account.setOperation("CREATE");
        producerService.sendMessage(account);
        return ResponseEntity.ok("Account create request sent to Kafka");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AccountDTO account) throws Exception {
        account.setId(id);
        account.setOperation("UPDATE");
        producerService.sendMessage(account);
        return ResponseEntity.ok("Account update request sent to Kafka");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        AccountDTO account = new AccountDTO();
        account.setId(id);
        account.setOperation("DELETE");
        producerService.sendMessage(account);
        return ResponseEntity.ok("Account delete request sent to Kafka");
    }
}
