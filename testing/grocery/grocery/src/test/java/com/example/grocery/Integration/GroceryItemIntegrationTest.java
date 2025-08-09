package com.example.grocery.Integration;


import com.example.grocery.repository.GroceryItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GroceryItemIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GroceryItemRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll(); // Clean up DB before each test
    }

    @Test
    void testCreateItem() throws Exception {
        mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "name": "Banana",
                        "quantity": 10,
                        "price": 0.99
                    }
                """))
                .andExpect(status().isCreated()) // ✅ Check HTTP 201
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()) // ✅ Check if ID is returned
                .andExpect(jsonPath("$.name").value("Banana"))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.price").value(0.99));
    }
}
