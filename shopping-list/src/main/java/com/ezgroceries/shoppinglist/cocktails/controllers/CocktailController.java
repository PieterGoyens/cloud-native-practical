package com.ezgroceries.shoppinglist.cocktails.controllers;

import com.ezgroceries.shoppinglist.cocktails.services.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    @GetMapping
    public List<CocktailResource> getCocktails(@RequestParam String search) {
        return cocktailService.searchCocktails(search);
    }
}