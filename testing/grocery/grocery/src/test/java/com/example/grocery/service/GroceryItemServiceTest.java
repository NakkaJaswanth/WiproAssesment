package com.example.grocery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.repository.GroceryItemRepository;

@ExtendWith(MockitoExtension.class)
public class GroceryItemServiceTest {

    @Mock
    private GroceryItemRepository repository;

    @InjectMocks
    private GroceryItemService service;

    @Test
    void testCreateItem() {
        GroceryItem item = new GroceryItem(null, "Apple", 5, 1.99);
        when(repository.save(item)).thenReturn(new GroceryItem(1L, "Apple", 5, 1.99));

        GroceryItem result = service.createItem(item);

        assertEquals("Apple", result.getName());
        verify(repository).save(item);
    }

    @Test
    void testGetItem() {
        GroceryItem item = new GroceryItem(1L, "Apple", 5, 1.99);
        when(repository.findById(1L)).thenReturn(Optional.of(item));

        GroceryItem result = service.getItem(1L);

        assertEquals("Apple", result.getName());
        verify(repository).findById(1L);
    }

    @Test
    void testDeleteItem() {
        service.deleteItem(1L);
        verify(repository).deleteById(1L);
    }
}
