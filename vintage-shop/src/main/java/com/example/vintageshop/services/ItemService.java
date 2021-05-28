package com.example.vintageshop.services;

import com.example.vintageshop.entities.Item;
import com.example.vintageshop.exceptions.ItemNotFoundException;
import com.example.vintageshop.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item getItem(Long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Item save(Item item) {
        return repository.save(item);
    }

    public void deleteItem(Long itemId) {
        repository.deleteById(itemId);
    }

    public Item updateItem(Item newItem, Long itemId) {
        return repository.findById(itemId)
                .map(employee -> {
                    employee.setName(newItem.getName());
                    employee.setDescription(newItem.getDescription());
                    return repository.save(employee);
                })
                .orElseThrow(() -> new ItemNotFoundException(itemId));
    }
}
