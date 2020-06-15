package com.ezgroceries.shoppinglist.shoppinglist;


import org.springframework.stereotype.Service;

@Service
public class ShoppinglistService {

    private final ShoppinglistRepository shoppinglistRepository;


    public ShoppinglistService(ShoppinglistRepository shoppinglistRepository) {
        this.shoppinglistRepository = shoppinglistRepository;
    }


}
