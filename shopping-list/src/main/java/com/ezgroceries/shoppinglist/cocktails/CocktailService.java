package com.ezgroceries.shoppinglist.cocktails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CocktailService {

    @Autowired
    private CocktailDBClient DBClient;

    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    public List<CocktailResource> searchCocktails(String search) {
        List<CocktailDBResponse.DrinkResource> responses;
//        List<CocktailResource> returnlist = new ArrayList<CocktailResource>();
        responses = searchExternalAPI(search);   //Zoek op de Externe API alles resultaten.
        return mergeCocktails(responses);   //Check of we die resultaten allemaal lokaal hebben, anders mergen.



   /*     for (CocktailDBResponse.DrinkResource rsc: responses) {
            returnlist.add(new CocktailResource(UUID.randomUUID(),
                    rsc.getStrDrink(),
                    rsc.getStrGlass(),
                    rsc.getStrInstructions(),
                    rsc.getStrDrinkThumb(),
                    Arrays.asList(rsc.getStrIngredient1(),rsc.getStrIngredient2(),rsc.getStrIngredient3(),rsc.getStrIngredient4(),
                            rsc.getStrIngredient5(),rsc.getStrIngredient6(),rsc.getStrIngredient7(),rsc.getStrIngredient8(),
                            rsc.getStrIngredient9(),rsc.getStrIngredient10()))
            );
        }*/
    }


    public List<CocktailDBResponse.DrinkResource> searchExternalAPI(String search) {
        return DBClient.searchCocktails(search).getDrinks();
    }

    public List<CocktailResource> mergeCocktails(List<CocktailDBResponse.DrinkResource> drinks) {
        //Get all the idDrink attributes
        List<String> ids = drinks.stream().map(CocktailDBResponse.DrinkResource::getIdDrink).collect(Collectors.toList());


        //Get all the ones we already have from our DB, use a Map for convenient lookup
        Map<String, CocktailEntity> existingEntityMap = cocktailRepository.findByIdDrinkIn(ids).stream().collect(Collectors.toMap(CocktailEntity::getIdDrink, o -> o, (o, o2) -> o));

        //Stream over all the drinks, map them to the existing ones, persist a new one if not existing
        Map<String, CocktailEntity> allEntityMap = drinks.stream().map(drinkResource -> {
            CocktailEntity cocktailEntity = existingEntityMap.get(drinkResource.getIdDrink());
            if (cocktailEntity == null) {
                CocktailEntity newCocktailEntity = new CocktailEntity();
                newCocktailEntity.setID(UUID.randomUUID());
                newCocktailEntity.setIdDrink(drinkResource.getIdDrink());
                newCocktailEntity.setNAME(drinkResource.getStrDrink());
                newCocktailEntity.setINGREDIENTS(Stream.of(drinkResource.getStrIngredient1(),
                        drinkResource.getStrIngredient2(),drinkResource.getStrIngredient3(),drinkResource.getStrIngredient4(),drinkResource.getStrIngredient5(),
                        drinkResource.getStrIngredient6(),drinkResource.getStrIngredient7(),drinkResource.getStrIngredient8(),drinkResource.getStrIngredient9(),
                        drinkResource.getStrIngredient10()).collect(Collectors.toSet()));
                cocktailEntity = cocktailRepository.save(newCocktailEntity);
            }
            return cocktailEntity;
        }).collect(Collectors.toMap(CocktailEntity::getIdDrink, o -> o, (o, o2) -> o));

        //Merge drinks and our entities, transform to CocktailResource instances
        return mergeAndTransform(drinks, allEntityMap);
    }


    private List<CocktailResource> mergeAndTransform(List<CocktailDBResponse.DrinkResource> drinks, Map<String, CocktailEntity> allEntityMap) {
        return drinks.stream().map(drinkResource -> new CocktailResource(allEntityMap.get(drinkResource.getIdDrink()).getID(), drinkResource.getStrDrink(), drinkResource.getStrGlass(),
                drinkResource.getStrInstructions(), drinkResource.getStrDrinkThumb(), getIngredients(drinkResource))).collect(Collectors.toList());
    }


    private List<String> getIngredients(CocktailDBResponse.DrinkResource drink){
        List<String> list = new ArrayList<>();
        list.add(drink.getStrIngredient1());
        list.add(drink.getStrIngredient2());
        list.add(drink.getStrIngredient3());
        list.add(drink.getStrIngredient4());
        list.add(drink.getStrIngredient5());
        list.add(drink.getStrIngredient6());
        list.add(drink.getStrIngredient7());
        list.add(drink.getStrIngredient8());
        list.add(drink.getStrIngredient9());
        list.add(drink.getStrIngredient10());
        return list;
    }

    public List<CocktailEntity> transformCocktail(List<CocktailResource> resources){
        List<CocktailEntity> Entities = resources.stream().map(temp -> {
            CocktailEntity obj = cocktailRepository.findById(temp.getCocktailId());
            return obj;
        }).collect(Collectors.toList());
        return Entities;
    }

}