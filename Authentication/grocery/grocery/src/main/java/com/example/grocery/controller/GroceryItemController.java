package com.example.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.service.GroceryItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/items")
public class GroceryItemController {

    @Autowired
    private GroceryItemService service;

    @PostMapping
    public ResponseEntity<GroceryItem> createItem(@Valid @RequestBody GroceryItem item) {
        return new ResponseEntity<>(service.createItem(item), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(service.getItem(id));
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @Valid @RequestBody GroceryItem item) {
        return ResponseEntity.ok(service.updateItem(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
