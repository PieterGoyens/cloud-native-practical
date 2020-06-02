package com.ezgroceries.shoppinglist.shoppinglist;

public class Shoppinglist {

    private String shoppingListId;
    private String name;

    public Shoppinglist(String shoppingListId, String name){
        this.shoppingListId = shoppingListId;
        this.name = name;
    }

    public String getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(String shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
