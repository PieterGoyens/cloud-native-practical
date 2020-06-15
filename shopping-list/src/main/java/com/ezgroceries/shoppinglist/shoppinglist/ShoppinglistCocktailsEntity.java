package com.ezgroceries.shoppinglist.shoppinglist;

import javax.persistence.*;
import java.util.UUID;



@Entity
@Table(name = "cocktail_shopping_list")
@IdClass(ShoppinglistKey.class)
public class ShoppinglistCocktailsEntity {

    @Id
    @Column(name="cocktail_id")
    private UUID cocktail_id;
    @Id
    @Column(name="shopping_list_id")
    private UUID shopping_list_id;


    public UUID getCocktail_id() {
        return cocktail_id;
    }

    public void setCocktail_id(UUID cocktail_id) {
        this.cocktail_id = cocktail_id;
    }

    public UUID getShopping_list_id() {
        return shopping_list_id;
    }

    public void setShopping_list_id(UUID shopping_list_id) {
        this.shopping_list_id = shopping_list_id;
    }
}
