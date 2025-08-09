package com.example.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.repository.GroceryItemRepository;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository repository;

    public GroceryItem createItem(GroceryItem item) {
        return repository.save(item);
    }

    public GroceryItem getItem(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        GroceryItem item = getItem(id);
        item.setName(updatedItem.getName());
        item.setQuantity(updatedItem.getQuantity());
        item.setPrice(updatedItem.getPrice());
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}
