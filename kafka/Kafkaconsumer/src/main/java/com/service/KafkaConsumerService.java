package com.service;

import java.util.Optional;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dto.AccountDTO;
import com.entity.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repository.AccountRepository;



@Service
public class KafkaConsumerService {

    private final AccountRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaConsumerService(AccountRepository repository) {
        this.repository = repository;
    }

    //Belongs to consumer group "account_group" (used for load balancing and fault tolerance).
    @KafkaListener(topics = "${wiproapp.topic.name}", groupId = "account_group")
    public void consume(String message) throws Exception {
        AccountDTO dto = objectMapper.readValue(message, AccountDTO.class);//Deserialization:Converts JSON message to an AccountDTO object.

        switch (dto.getOperation()) {
            case "CREATE":
                repository.save(new Account(dto.getId(), dto.getName(), dto.getBalance()));
                break;
            case "UPDATE":
                Optional<Account> existing = repository.findById(dto.getId());
                if (existing.isPresent()) {
                    Account acc = existing.get();
                    acc.setName(dto.getName());
                    acc.setBalance(dto.getBalance());
                    repository.save(acc);
                }
                break;
            case "DELETE":
                repository.deleteById(dto.getId());
                break;
        }
    }
}
