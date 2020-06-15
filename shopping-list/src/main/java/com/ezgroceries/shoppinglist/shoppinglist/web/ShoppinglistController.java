package com.ezgroceries.shoppinglist.shoppinglist.web;


import com.ezgroceries.shoppinglist.cocktails.CocktailResource;
import com.ezgroceries.shoppinglist.shoppinglist.Shoppinglist;
import com.ezgroceries.shoppinglist.shoppinglist.ShoppinglistName;
import com.ezgroceries.shoppinglist.shoppinglist.ShoppinglistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class ShoppinglistController {

    @Autowired
    private ShoppinglistService shoppinglistService;


    public List<Shoppinglist> list = getDummyShoppinlist();


    //Create shopping list
    @PostMapping(value = "/shopping-lists")
    @ResponseStatus(HttpStatus.CREATED) // 201 return code
    public ShoppinglistName createShoppinglist(@RequestBody ShoppinglistName name) {
        return shoppinglistService.create(name.getName());
    }

    //Add Products to Shopping list
    @PostMapping(value = "/shopping-lists/{listId}/cocktails")
    public List<CocktailResource> addProduct(@PathVariable UUID listId, @RequestBody List<CocktailResource> cocktailResources) {
        return cocktailResources;
    }

    //Return a shopping list
    @GetMapping(value = "/shopping-lists/{listId}")
    public Shoppinglist findShoppinglist(@PathVariable UUID listId) {
        Shoppinglist returnlist = null;
        for (Shoppinglist shl : list) {
            if (shl.getShoppingListId().equals(listId)) {
                returnlist = shl;
            }
        }
        return returnlist;
    }



    //Return all shopping lists
    @GetMapping(value = "/shopping-lists")
    public List<Shoppinglist> getShoppinglists() {
        return list;
    }



    private List<Shoppinglist> getDummyShoppinlist() {
        return Arrays.asList(
                new Shoppinglist(
                        UUID.fromString("90689338-499a-4c49-af90-f1e73068ad4f"),"Stephanie's birthday",
                        Arrays.asList("Triple sec", "Lime juice", "Salt","Blue Curacao")
                    ),
                new Shoppinglist(
                        UUID.fromString("6c7d09c2-8a25-4d54-a979-25ae779d2465"),"My Birthday",
                        Arrays.asList("Triple sec", "Lime juice", "Salt","Blue Curacao")
                    )
        );
    }



}
