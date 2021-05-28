package com.example.vintageshop.controllers;

import com.example.vintageshop.entities.Item;
import com.example.vintageshop.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping(value="/{itemId}")
    public Item getItem(@PathVariable("itemId") Long itemId) {
        return service.getItem(itemId);
    }

    @PutMapping(value="/{itemId}")
    public Item updateItem(@RequestBody Item newItem, @PathVariable("itemId") Long itemId) {
        return service.updateItem(newItem, itemId);
    }

    @PostMapping
    public Item saveItem(@RequestBody Item item) {
        return service.save(item);
    }

    @DeleteMapping(value="{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        service.deleteItem(itemId);
    }

}
