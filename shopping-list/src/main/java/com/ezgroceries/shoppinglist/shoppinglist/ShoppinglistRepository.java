package com.ezgroceries.shoppinglist.shoppinglist;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface ShoppinglistRepository extends Repository<ShoppinglistEntity, UUID> {


    public ShoppinglistEntity findByID(UUID id);

    public void save(ShoppinglistEntity entity);

}
