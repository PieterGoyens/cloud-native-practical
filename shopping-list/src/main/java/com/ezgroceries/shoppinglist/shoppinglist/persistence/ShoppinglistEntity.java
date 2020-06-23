package com.ezgroceries.shoppinglist.shoppinglist.persistence;


import com.ezgroceries.shoppinglist.cocktails.persistence.CocktailEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shopping_list")
public class ShoppinglistEntity {

    @Id
    @Column(name="ID")
    private UUID ID;
    @Column(name="name")
    private String NAME;
    @JoinTable(
            name = "cocktail_shopping_list",
            joinColumns = @JoinColumn(
                    name = "shopping_list_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cocktail_id",
                    referencedColumnName = "id"
            )
    )
    @OneToMany
    private List<CocktailEntity> cocktails;

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public List<CocktailEntity> getCocktails() {
        return cocktails;
    }

    public void setCocktails(List<CocktailEntity> cocktails) {
        this.cocktails = cocktails;
    }
}
