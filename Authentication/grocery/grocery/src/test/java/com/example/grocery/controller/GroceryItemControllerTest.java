package com.example.grocery.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.service.GroceryItemService;

@WebMvcTest(GroceryItemController.class)
class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService service;

    @Test
    void testCreateItem() throws Exception {
        GroceryItem item = new GroceryItem(1L, "Apple", 5, 1.99);
        when(service.createItem(any())).thenReturn(item);

        mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "name": "Apple",
                        "quantity": 5,
                        "price": 1.99
                    }
                """))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("Apple"));
    }

    @Test
    void testGetItem() throws Exception {
        GroceryItem item = new GroceryItem(1L, "Apple", 5, 1.99);
        when(service.getItem(1L)).thenReturn(item);

        mockMvc.perform(get("/api/items/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Apple"));
    }
}
