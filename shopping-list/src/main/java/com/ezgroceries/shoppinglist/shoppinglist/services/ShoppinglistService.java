package com.ezgroceries.shoppinglist.shoppinglist.services;


import com.ezgroceries.shoppinglist.cocktails.persistence.CocktailEntity;
import com.ezgroceries.shoppinglist.cocktails.controllers.CocktailResource;
import com.ezgroceries.shoppinglist.cocktails.services.CocktailService;
import com.ezgroceries.shoppinglist.shoppinglist.persistence.ShoppinglistEntity;
import com.ezgroceries.shoppinglist.shoppinglist.persistence.ShoppinglistRepository;
import com.ezgroceries.shoppinglist.shoppinglist.controllers.Shoppinglist;
import com.ezgroceries.shoppinglist.shoppinglist.controllers.ShoppinglistName;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ShoppinglistName create(String name) {
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


    public Shoppinglist searchShoppinglist(UUID id) {
        ShoppinglistEntity shoppinglist = shoppinglistRepository.findByID(id);
        Shoppinglist responsList = new Shoppinglist(shoppinglist.getID(), shoppinglist.getNAME(), cocktailsToIngredients(shoppinglist.getCocktails()));
        return responsList;
    }

    public List<Shoppinglist> getAllLists(){
        List<Shoppinglist> responseList= new ArrayList<>();
        for (ShoppinglistEntity tmp : shoppinglistRepository.findAll()) {
            responseList.add(new Shoppinglist(tmp.getID(),tmp.getNAME(),cocktailsToIngredients(tmp.getCocktails())));
        }
    return responseList;
    }

    private List<String> cocktailsToIngredients(List<CocktailEntity> drinks){
        List<String> ingredients = new ArrayList<>();
        for (CocktailEntity tmp : drinks) {
            ingredients.addAll(tmp.getINGREDIENTS());
        }
        return ingredients;
    }
}
