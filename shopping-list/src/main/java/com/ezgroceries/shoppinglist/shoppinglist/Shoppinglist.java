package com.ezgroceries.shoppinglist.shoppinglist;

import java.util.UUID;

public class Shoppinglist {

    private UUID shoppingListId;
    private String name;

    public Shoppinglist(String name){
        this.name = name;
        shoppingListId = UUID.randomUUID();
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
