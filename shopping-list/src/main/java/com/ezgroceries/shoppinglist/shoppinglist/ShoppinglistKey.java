package com.ezgroceries.shoppinglist.shoppinglist;

import java.io.Serializable;
import java.util.UUID;

public class ShoppinglistKey implements Serializable {

    private UUID cocktail_id;
    private UUID shopping_list_id;

    public ShoppinglistKey(UUID cocktail_id, UUID shopping_list_id) {
        this.cocktail_id = cocktail_id;
        this.shopping_list_id = shopping_list_id;
    }
}
