package com.ezgroceries.shoppinglist.shoppinglist.web;


import com.ezgroceries.shoppinglist.shoppinglist.Shoppinglist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppinglistController {

    @PostMapping(value = "/shopping-lists")
    @ResponseStatus(HttpStatus.CREATED) // 201 return code
    public Shoppinglist createShoppinglist(@RequestBody String name) {
        return new Shoppinglist(name);
    }

}
