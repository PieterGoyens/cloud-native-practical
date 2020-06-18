package com.ezgroceries.shoppinglist.shoppinglist;


import com.ezgroceries.shoppinglist.cocktails.CocktailResource;
import com.ezgroceries.shoppinglist.cocktails.CocktailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppinglistService {

    private final ShoppinglistRepository shoppinglistRepository;
    private final CocktailService cocktailService;


    public ShoppinglistService(ShoppinglistRepository shoppinglistRepository, CocktailService cocktailService) {
        this.shoppinglistRepository = shoppinglistRepository;
        this.cocktailService = cocktailService;
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
        ShoppinglistEntity shoppinglistEntity = shoppinglistRepository.findByID(listId);
        //CocktailResource omzetten naar CocktailEntity
        shoppinglistEntity.setCocktails(cocktailService.transformCocktail(cocktailResources));
        shoppinglistRepository.save(shoppinglistEntity);
    }
}
