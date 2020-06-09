package com.ezgroceries.shoppinglist.cocktails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CocktailService {

    @Autowired
    private CocktailDBClient DBClient;

    public List<Cocktail> searchCocktails(String search) {
        List<CocktailDBResponse.DrinkResource> responses;
        List<Cocktail> returnlist = new ArrayList<Cocktail>();
        responses = searchInDB(search);
        for (CocktailDBResponse.DrinkResource rsc: responses) {
            returnlist.add(new Cocktail(UUID.randomUUID(),
                    rsc.getStrDrink(),
                    rsc.getStrGlass(),
                    rsc.getStrInstructions(),
                    rsc.getStrDrinkThumb(),
                    Arrays.asList(rsc.getStrIngredient1(),rsc.getStrIngredient2(),rsc.getStrIngredient3(),rsc.getStrIngredient4(),
                            rsc.getStrIngredient5(),rsc.getStrIngredient6(),rsc.getStrIngredient7(),rsc.getStrIngredient8(),
                            rsc.getStrIngredient9(),rsc.getStrIngredient10()))
            );
        }
        return returnlist;
    }


    public List<CocktailDBResponse.DrinkResource> searchInDB(String search) {
        return DBClient.searchCocktails(search).getDrinks();
    }
}
