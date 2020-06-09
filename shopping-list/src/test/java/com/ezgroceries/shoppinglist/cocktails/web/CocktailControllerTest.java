package com.ezgroceries.shoppinglist.cocktails.web;

import com.ezgroceries.shoppinglist.cocktails.CocktailDBResponse;
import com.ezgroceries.shoppinglist.cocktails.CocktailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CocktailController.class)
class CocktailControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CocktailService cocktailService;

    @Test
    public void testGetCockatils() throws Exception{
      given(cocktailService.searchInDB("russian"))
            .willReturn(getdummyDBResponse());

        mockMvc.perform(get("/cocktails?search=russian")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));

        verify(cocktailService).searchInDB("russian");

    }


    private List<CocktailDBResponse.DrinkResource> getdummyDBResponse() {
        return Arrays.asList(
                new CocktailDBResponse.DrinkResource("11102","Black Russian","Old-fashioned glass",
                        "Pour the ingredients into an old fashioned glass filled with ice cubes. Stir gently.",
                        "https://www.thecocktaildb.com/images/media/drink/2k5gbb1504367689.jpg",
                        "Coffee liqueur","Vodka",null,null,null,null,null,null,null,null),
                new CocktailDBResponse.DrinkResource("12528","White Russian","Old-fashioned glass",
                        "Pour vodka and coffee liqueur over ice cubes in an old-fashioned glass. Fill with light cream and serve.",
                        "https://www.thecocktaildb.com/images/media/drink/vsrupw1472405732.jpg",
                        "Vodka","Coffee liqueur","Light cream",null,null,null,null,null,null,null)
                        );
    }

    /*
    @Test
    public void testGetCockatils() throws Exception{
        mockMvc.perform(get("/cocktails?search=","Russian")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }*/
}