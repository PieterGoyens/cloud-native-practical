package com.ezgroceries.shoppinglist.shoppinglist;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "shopping_list")
public class ShoppinglistEntity {

    @Id
    @Column(name="id")
    private UUID ID;
    @Column(name="name")
    private String NAME;


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
}
