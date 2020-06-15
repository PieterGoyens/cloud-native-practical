package com.ezgroceries.shoppinglist.shoppinglist;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShoppinglistRepository extends CrudRepository<ShoppinglistEntity, UUID>  {

}
