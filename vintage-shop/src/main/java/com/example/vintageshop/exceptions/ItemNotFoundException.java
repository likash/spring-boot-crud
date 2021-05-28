package com.example.vintageshop.exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(Long id) {

        super(String.format("Item with Id %d not found", id));
    }
}
