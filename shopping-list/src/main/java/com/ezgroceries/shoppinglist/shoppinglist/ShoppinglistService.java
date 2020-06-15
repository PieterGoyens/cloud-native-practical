package com.ezgroceries.shoppinglist.shoppinglist;


import com.ezgroceries.shoppinglist.cocktails.CocktailResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppinglistService {

    private final ShoppinglistRepository shoppinglistRepository;


    public ShoppinglistService(ShoppinglistRepository shoppinglistRepository) {
        this.shoppinglistRepository = shoppinglistRepository;
    }

    public ShoppinglistName create(String name){
        ShoppinglistName shoppinglistName = new ShoppinglistName(name);
        ShoppinglistEntity entity = new ShoppinglistEntity();
        entity.setID(UUID.randomUUID());
        entity.setNAME(shoppinglistName.getName());
        shoppinglistRepository.save(entity);
        return shoppinglistName;
    }


    public void addCocktails(UUID listId, List<CocktailResource> cocktailResources) {


    }
}
