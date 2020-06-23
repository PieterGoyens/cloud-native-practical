package com.ezgroceries.shoppinglist.cocktails.persistence;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface CocktailRepository extends Repository<CocktailEntity, UUID> {

        List<CocktailEntity> findByIdDrinkIn(List<String> id);

        CocktailEntity findById(UUID id);

        List<CocktailEntity> findByNameContainingIgnoreCase(String input);

        CocktailEntity save(CocktailEntity entity);

}
