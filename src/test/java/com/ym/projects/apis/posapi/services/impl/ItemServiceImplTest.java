package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.*;
import com.ym.projects.apis.posapi.repositories.ItemRepository;
import com.ym.projects.apis.posapi.services.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ItemServiceImplTest extends BaseTestCase {
    private static Item item;
    private static final String TYPE_DESC_1="ITEM TYPE DESCRIPTION 1";
    private static final String CATEGORY_DESC_1="ITEM CATEGORY DESCRIPTION 1";
    private static final String UOM_DESC_1="PIECES";
    private final String WH_DESC = "WAREHOUSE 1";
    private final String LOC_DESC = "LOCATION 1";
    private static final String LOC_DESC_1="Location DESCRIPTION 1";
    private static UnitOfMeasure unitOfMeasure;
    private static Warehouse warehouse;
    private static Location location;
    private static final String BASE_UOM = "PCS";
    private static final float BASE_RATE = 1f;

    private ItemType itemType;
    private ItemCategory itemCategory;
    @Mock
    private static ItemRepository itemRepository;
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        itemType = ItemType.builder().id(ID).description(TYPE_DESC_1).build();
        itemCategory = ItemCategory.builder().id(ID).description(TYPE_DESC_1).build();
        unitOfMeasure=UnitOfMeasure.builder().id(ID).description(CATEGORY_DESC_1).build();
        warehouse=Warehouse.builder().id(ID).description(WH_DESC).build();
        location=Location.builder().id(ID).description(LOC_DESC).build();
        item=Item.builder().itemType(itemType).unitOfMeasure(unitOfMeasure).location(location).build();
        itemService = new ItemServiceImpl(itemRepository);
    }

    @Test
    void findAllItem() {
        List<Item> items= new ArrayList<>();
        items.add(item);
        when(itemService.findAllItem()).thenReturn(items);
        assertEquals(items.size(), itemService.findAllItem().size());
    }

    @Test
    void findItemById() {
        when(itemRepository.findById(ID)).thenReturn(Optional.of(item));
        assertEquals(item.getId(), itemService.findItemById(ID).getId());
    }

    @Test
    void saveOrUpdateItem() {
        ArgumentCaptor<Item> captor = ArgumentCaptor.forClass(Item.class);
        itemService.saveOrUpdateItem(item);
        verify(itemRepository, times(1)).save(captor.capture());
        assertEquals(item.getId(), captor.getValue().getId());
    }

    @Test
    void deleteItemById() {
        itemService.deleteItemById(ID);
        verify(itemRepository, times(1)).deleteById(ID);
    }
}