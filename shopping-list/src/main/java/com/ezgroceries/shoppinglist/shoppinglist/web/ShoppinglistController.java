package com.ezgroceries.shoppinglist.shoppinglist.web;


import com.ezgroceries.shoppinglist.cocktails.Cocktail;
import com.ezgroceries.shoppinglist.shoppinglist.Shoppinglist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    //Return a shopping list
    @GetMapping(value = "/shopping-lists/{listId}")
    public Shoppinglist getShoppinglist(@PathVariable UUID listId) {
        return getDummyShoppinlist();
    }



    private Shoppinglist getDummyShoppinlist() {
        return new Shoppinglist(
                        UUID.fromString("90689338-499a-4c49-af90-f1e73068ad4f"),"Stephanie's birthday",
                        Arrays.asList("Triple sec", "Lime juice", "Salt","Blue Curacao"));
    }

}
