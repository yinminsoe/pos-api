package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.ItemCategory;
import com.ym.projects.apis.posapi.repositories.ItemCategoryRepository;
import com.ym.projects.apis.posapi.services.ItemCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemCategoryServiceImplTest extends BaseTestCase {
    private ItemCategory itemCategory;
    private final String DESC_1 = "Item Category Description 1";

    @Mock
    private ItemCategoryRepository itemCategoryRepository;
    private ItemCategoryService itemCategoryService;


    @BeforeEach
    void setUp() {
        itemCategoryService = new ItemCategoryServiceImpl(itemCategoryRepository);
        itemCategory = ItemCategory.builder().id(ID).description(DESC_1).build();

    }

    @Test
    void findAllItemCategory() {
        List<ItemCategory> itemCategoryList = new ArrayList<>();
        itemCategoryList.add(itemCategory);
        when(itemCategoryRepository.findAll()).thenReturn(itemCategoryList);
        assertEquals(itemCategoryList.size(), itemCategoryService.findAllItemCategory().size());
    }

    @Test
    void findItemCategoryById() {
        when(itemCategoryRepository.findById(ID)).thenReturn(Optional.of(itemCategory));
        assertEquals(ID, itemCategoryService.findItemCategoryById(ID).getId());
    }

    @Test
    void saveAndUpdateItemCategory() {
        ArgumentCaptor<ItemCategory> captor = ArgumentCaptor.forClass(ItemCategory.class);
        itemCategoryService.saveAndUpdateItemCategory(itemCategory);
        verify(itemCategoryRepository, times(1)).save(captor.capture());
        assertEquals(itemCategory.getId(), captor.getValue());
    }

    @Test
    void deleteItemCategoryById() {
        itemCategoryService.deleteItemCategoryById(ID);
        verify(itemCategoryRepository,times(1)).deleteById(ID);
    }
}