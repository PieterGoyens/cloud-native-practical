package com.ezgroceries.shoppinglist.cocktails;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface CocktailRepository extends Repository<CocktailEntity, UUID> {

        public List<CocktailEntity> findByIdDrinkIn(List<String> id);

        public CocktailEntity findById(UUID id);

        public CocktailEntity save(CocktailEntity entity);

}
