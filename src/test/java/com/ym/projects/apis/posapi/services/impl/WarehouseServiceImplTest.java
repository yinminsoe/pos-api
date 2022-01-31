package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.Warehouse;
import com.ym.projects.apis.posapi.repositories.WarehouseRepository;
import com.ym.projects.apis.posapi.services.WarehouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WarehouseServiceImplTest extends BaseTestCase {
    private final String WH_DESC = "WAREHOUSE 1";
    private final String WH_DESC_2 = "WAREHOUSE 2";

    @Mock
    private WarehouseRepository warehouseRepository;
    private WarehouseService warehouseService;
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        warehouseService = new WarehouseServiceImpl(warehouseRepository);
        warehouse = Warehouse.builder().id(ID).name(WH_DESC).build();
    }

    @Test
    void findAllWarehouse() {
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(warehouse);

        when(warehouseRepository.findAll()).thenReturn(warehouseList);
        warehouseService.findAllWarehouse();

        assertEquals(1, warehouseList.size());
    }

    @Test
    void findWarehouseById() {
        when(warehouseRepository.findById(ID)).thenReturn(Optional.of(warehouse));
        Warehouse tempWarehouse = warehouseService.findWarehouseById(ID);
        assertEquals(ID, tempWarehouse.getId());
    }

    @Test
    void saveAndUpdateWarehouse() {
        warehouse.setName(WH_DESC_2);
        when(warehouseRepository.save(warehouse)).thenReturn(warehouse);
        Warehouse tempWarehouse = warehouseService.saveAndUpdateWarehouse(warehouse);
        assertEquals(WH_DESC_2, tempWarehouse.getName());
    }

    @Test
    void deleteWarehouseById() {
        warehouseService.deleteWarehouseById(ID);
        verify(warehouseRepository, times(1)).deleteById(ID);
    }
}