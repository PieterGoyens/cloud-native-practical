package com.ezgroceries.shoppinglist.shoppinglist;

import com.ezgroceries.shoppinglist.cocktails.Cocktail;

import java.util.*;

public class Shoppinglist{

    private UUID shoppingListId;
    private String name;
    private ArrayList<Cocktail> cocktails = new ArrayList<>();

    public Shoppinglist(String name){
        this.name = name;
        shoppingListId = UUID.randomUUID();
    }

    //Tijdelijke constructor om even lijst via UUID te kunnen aanamken.
    public Shoppinglist(UUID shoppingListId){
        this.name = "No_Name";
        this.shoppingListId = shoppingListId;
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

    public List<Cocktail> addCocktails(List<Cocktail> cocktailsIn) {
        return cocktailsIn;
    }


}
