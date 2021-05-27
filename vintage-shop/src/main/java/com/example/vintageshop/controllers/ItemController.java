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

    @RequestMapping(value="/{itemId}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("itemId") Long itemId) {
        return service.getItem(itemId);
    }

    @RequestMapping(value="/{itemId}", method = RequestMethod.PUT)
    public Item updateItem(@RequestBody Item newItem, @PathVariable("itemId") Long itemId) {
        return service.updateItem(newItem, itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item saveItem(@RequestBody Item item) {
        return service.save(item);
    }

    @RequestMapping(value="{itemId}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        service.deleteItem(itemId);
    }

}
