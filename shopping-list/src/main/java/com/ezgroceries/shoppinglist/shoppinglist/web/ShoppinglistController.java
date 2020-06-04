package com.ezgroceries.shoppinglist.shoppinglist.web;


import com.ezgroceries.shoppinglist.cocktails.Cocktail;
import com.ezgroceries.shoppinglist.shoppinglist.Shoppinglist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ShoppinglistController {

    //Create shopping list
    @PostMapping(value = "/shopping-lists")
    @ResponseStatus(HttpStatus.CREATED) // 201 return code
    public Shoppinglist createShoppinglist(@RequestBody String name) {

        return new Shoppinglist(name);
    }

    //Add Products to Shopping list
    @PostMapping(value = "/shopping-lists/{listId}/cocktails")
    public List<Cocktail> addProduct(@PathVariable UUID listId, @RequestBody List<Cocktail> cocktails) {
        return cocktails;
    }

}
