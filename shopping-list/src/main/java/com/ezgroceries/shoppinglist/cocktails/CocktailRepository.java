package com.ezgroceries.shoppinglist.cocktails;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CocktailRepository extends CrudRepository<CocktailEntity, UUID> {

        public List<CocktailEntity> findByIdDrinkIn(List<String> id);

}
