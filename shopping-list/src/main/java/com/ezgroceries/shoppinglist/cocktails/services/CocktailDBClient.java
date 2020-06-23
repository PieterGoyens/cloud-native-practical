package com.ezgroceries.shoppinglist.cocktails.services;


import com.ezgroceries.shoppinglist.cocktails.persistence.CocktailEntity;
import com.ezgroceries.shoppinglist.cocktails.persistence.CocktailRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@FeignClient(name = "cocktailDBClient", url = "https://www.thecocktaildb.com/api/json/v1/1")
public interface CocktailDBClient {

    @GetMapping(value = "search.php")
    CocktailDBResponse searchCocktails(@RequestParam("s") String search);

    @Component
    class CocktailDBClientFallback implements CocktailDBClient {

        private final CocktailRepository cocktailRepository;

        public CocktailDBClientFallback(CocktailRepository cocktailRepository) {
            this.cocktailRepository = cocktailRepository;
        }

        @Override
        public CocktailDBResponse searchCocktails(String search) {
            List<CocktailEntity> cocktailEntities = cocktailRepository.findByNameContainingIgnoreCase(search);
            CocktailDBResponse cocktailDBResponse = new CocktailDBResponse();
            cocktailDBResponse.setDrinks(cocktailEntities.stream().map(cocktailEntity -> {
                CocktailDBResponse.DrinkResource drinkResource = new CocktailDBResponse.DrinkResource();
                drinkResource.setIdDrink(cocktailEntity.getIdDrink());
                drinkResource.setStrDrink(cocktailEntity.getNAME());
                drinkResource.setStrDrinkThumb(cocktailEntity.getIMAGE_LINK());
                drinkResource.setStrGlass(cocktailEntity.getGLASS());
                drinkResource.setStrInstructions(cocktailEntity.getINSTRUCTIONS());
                List ingr_list = Arrays.asList(cocktailEntity.getINGREDIENTS().toArray());
                drinkResource.setStrIngredient1(ingr_list.get(0).toString());
                drinkResource.setStrIngredient2(ingr_list.get(1).toString());
                drinkResource.setStrIngredient3(ingr_list.get(2).toString());
                drinkResource.setStrIngredient4(ingr_list.get(3).toString());
                drinkResource.setStrIngredient5(ingr_list.get(4).toString());
                drinkResource.setStrIngredient6(ingr_list.get(5).toString());
                drinkResource.setStrIngredient7(ingr_list.get(6).toString());
                drinkResource.setStrIngredient8(ingr_list.get(7).toString());
                drinkResource.setStrIngredient9(ingr_list.get(8).toString());
                drinkResource.setStrIngredient10(ingr_list.get(9).toString());
                return drinkResource;
            }).collect(Collectors.toList()));

            return cocktailDBResponse;
        }
    }
}
