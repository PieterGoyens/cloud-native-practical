package com.ezgroceries.shoppinglist.shoppinglist.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ShoppinglistControllerTest {


    @Autowired
    MockMvc mockMvc;


    @Test
    public void testcreateShoppinglist() throws Exception {
        mockMvc.perform(post("/shopping-lists")
                .content("[{'cocktailId': '23b3d85a-3928-41c0-a533-6538a71e17c4'}]")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    @Disabled
    public void testaddProduct() throws Exception {
        mockMvc.perform(post("/shopping-lists/{listId}/cocktails", "97c8e5bd-5353-426e-b57b-69eb2260ace3")
                .content("[{'cocktailId': '23b3d85a-3928-41c0-a533-6538a71e17c4'}]")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    @Disabled
    public void testfindShoppinglist() throws Exception {
        mockMvc.perform(get("/shopping-lists/{listId}","97c8e5bd-5353-426e-b57b-69eb2260ace3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testgetShoppinglists() throws Exception {
        mockMvc.perform(get("/shopping-lists")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}