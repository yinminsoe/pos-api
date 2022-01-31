package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.Item;
import com.ym.projects.apis.posapi.model.ItemType;
import com.ym.projects.apis.posapi.repositories.ItemTypeRepository;
import com.ym.projects.apis.posapi.services.ItemTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemTypeServiceImplTest extends BaseTestCase {

    private static final String DESC_1="ITEM TYPE DESCRIPTION 1";


    private ItemType itemType;
    @Mock
    private ItemTypeRepository itemTypeRepository;
    private ItemTypeService itemTypeService;

    @BeforeEach
    public void setUp(){
        itemType = ItemType.builder().id(ID).description(DESC_1).build();
        itemTypeService= new ItemTypeServiceImpl(itemTypeRepository);
    }

    @Test
    void findAllItemType() {
        List<ItemType> itemTypeList = new ArrayList<>();
        itemTypeList.add(itemType);
        when(itemTypeRepository.findAll()).thenReturn(itemTypeList);
        assertEquals(itemTypeList.size(), itemTypeService.findAllItemType().size());
    }

    @Test
    void findItemTypeById() {
        when(itemTypeRepository.findById(ID)).thenReturn(Optional.of(itemType));
        assertEquals(itemType.getId(),itemTypeService.findItemTypeById(ID).getId());
    }

    @Test
    void saveAndUpdateItemType() {
        ArgumentCaptor<ItemType> captor = ArgumentCaptor.forClass(ItemType.class);
        itemTypeService.saveAndUpdateItemType(itemType);
        verify(itemTypeRepository, times(1)).save(captor.capture());
        assertEquals(itemType.getId(), captor.getValue().getId());
    }

    @Test
    void deleteItemTypeById() {
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        itemTypeService.deleteItemTypeById(ID);
        verify(itemTypeRepository, times(1)).deleteById(captor.capture());
        assertEquals(itemType.getId(), captor.getValue());

    }
}