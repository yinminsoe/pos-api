package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.entity.Item;
import com.ym.projects.apis.posapi.repositories.ItemRepository;
import com.ym.projects.apis.posapi.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item saveOrUpdateItem(Item itemType) {
        return itemRepository.save(itemType);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
