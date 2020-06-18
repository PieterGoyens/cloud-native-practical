package com.ezgroceries.shoppinglist.shoppinglist.web;


import com.ezgroceries.shoppinglist.cocktails.CocktailResource;
import com.ezgroceries.shoppinglist.shoppinglist.Shoppinglist;
import com.ezgroceries.shoppinglist.shoppinglist.ShoppinglistName;
import com.ezgroceries.shoppinglist.shoppinglist.ShoppinglistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ShoppinglistController {

    @Autowired
    private ShoppinglistService shoppinglistService;


    //Create shopping list
    @PostMapping(value = "/shopping-lists")
    @ResponseStatus(HttpStatus.CREATED) // 201 return code
    public ShoppinglistName createShoppinglist(@RequestBody ShoppinglistName name) {
        return shoppinglistService.create(name.getName());
    }

    //Add Products to Shopping list
    @PostMapping(value = "/shopping-lists/{listId}/cocktails")
    public List<CocktailResource> addProduct(@PathVariable UUID listId, @RequestBody List<CocktailResource> cocktailResources) {
        shoppinglistService.addCocktails(listId,cocktailResources);
        return cocktailResources;
    }

    //Return a shopping list
    @GetMapping(value = "/shopping-lists/{listId}")
    public Shoppinglist findShoppinglist(@PathVariable UUID listId) {
        return shoppinglistService.searchShoppinglist(listId);
    }



    //Return all shopping lists
    @GetMapping(value = "/shopping-lists")
    public List<Shoppinglist> getShoppinglists() {
        return shoppinglistService.getAllLists();
    }


}
