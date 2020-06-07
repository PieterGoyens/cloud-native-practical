package com.ezgroceries.shoppinglist.shoppinglist;

import java.util.List;
import java.util.UUID;

public class Shoppinglist{

    private UUID shoppingListId;
    private String name;
//    private List<Cocktail> cocktails = new ArrayList<>();
    private List<String> ingredients;


    public Shoppinglist(String name){
        this.name = name;
        shoppingListId = UUID.randomUUID();
    }

    //Tijdelijke constructor om even lijst via UUID te kunnen aanamken.
    public Shoppinglist(UUID shoppingListId){
        this.name = "No_Name";
        this.shoppingListId = shoppingListId;
    }

    public Shoppinglist(UUID shoppingListId, String name, List<String> ingredients ){
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = ingredients;
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    /*public List<Cocktail> getCocktails() {
        return cocktails;
    }

    public void setCocktails(List<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    public List<Cocktail> addCocktails(List<Cocktail> cocktailsIn) {
        return cocktailsIn;
    }
*/

}
