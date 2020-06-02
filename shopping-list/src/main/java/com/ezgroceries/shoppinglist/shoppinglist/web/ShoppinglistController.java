package com.ezgroceries.shoppinglist.shoppinglist.web;


import com.ezgroceries.shoppinglist.shoppinglist.Shoppinglist;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppinglistController {

    @PostMapping(value = "/shopping-lists")
    public Shoppinglist createShoppinglist(@RequestBody Shoppinglist newList) {
        return newList;
    }


}
