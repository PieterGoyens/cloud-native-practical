package com.ezgroceries.shoppinglist.cocktails.persistence;

import com.ezgroceries.shoppinglist.utils.StringSetConverter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cocktail")
public class CocktailEntity{

    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="id_drink")
    private String idDrink;
    @Column(name="name")
    private String name;
    @Column(name="ingredients")
    @Convert(converter = StringSetConverter.class)
    private Set<String> INGREDIENTS;
    @Column(name="glass")
    private String GLASS;
    @Column(name="instructions")
    private String INSTRUCTIONS;
    @Column(name="image_link")
    private String IMAGE_LINK;

    public UUID getId() {
        return id;
    }

    public void setId(UUID ID) {
        this.id = ID;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String ID_DRINK) {
        this.idDrink = ID_DRINK;
    }

    public String getNAME() {
        return name;
    }

    public void setNAME(String NAME) {
        this.name = NAME;
    }

    public Set<String> getINGREDIENTS() {
        return INGREDIENTS;
    }

    public void setINGREDIENTS(Set<String> INGREDIENTS) {
        this.INGREDIENTS = INGREDIENTS;
    }

    public String getGLASS() {
        return GLASS;
    }

    public void setGLASS(String GLASS) {
        this.GLASS = GLASS;
    }

    public String getINSTRUCTIONS() {
        return INSTRUCTIONS;
    }

    public void setINSTRUCTIONS(String INSTRUCTIONS) {
        this.INSTRUCTIONS = INSTRUCTIONS;
    }

    public String getIMAGE_LINK() {
        return IMAGE_LINK;
    }

    public void setIMAGE_LINK(String IMAGE_LINK) {
        this.IMAGE_LINK = IMAGE_LINK;
    }
}
