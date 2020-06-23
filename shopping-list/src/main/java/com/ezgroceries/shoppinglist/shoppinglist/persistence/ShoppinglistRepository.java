package com.ezgroceries.shoppinglist.shoppinglist.persistence;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface ShoppinglistRepository extends Repository<ShoppinglistEntity, UUID> {


    public ShoppinglistEntity findByID(UUID id);

    public void save(ShoppinglistEntity entity);

    public List<ShoppinglistEntity> findAll();

}
