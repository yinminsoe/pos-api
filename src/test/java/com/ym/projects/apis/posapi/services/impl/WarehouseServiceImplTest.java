package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.exception.ResourceNotFoundException;
import com.ym.projects.apis.posapi.mapper.WarehouseMapper;
import com.ym.projects.apis.posapi.entity.Company;
import com.ym.projects.apis.posapi.entity.Country;
import com.ym.projects.apis.posapi.entity.Tax;
import com.ym.projects.apis.posapi.entity.Warehouse;
import com.ym.projects.apis.posapi.repositories.WarehouseRepository;
import com.ym.projects.apis.posapi.services.WarehouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WarehouseServiceImplTest extends BaseTestCase {
    private final String WH_DESC = "WAREHOUSE 1";
    private final String WH_DESC_2 = "WAREHOUSE 2";
    private Company company;

    @Mock
    private WarehouseRepository warehouseRepository;

    private WarehouseMapper warehouseMapper=WarehouseMapper.INSTANCE;
    private WarehouseService warehouseService;
    private Warehouse warehouse;
    private WarehouseDto warehouseDto;

    @BeforeEach
    void setUp() {
        warehouseService = new WarehouseServiceImpl( warehouseMapper,warehouseRepository);
        company = Company.builder().id(ID).name("YMS YGN COMPANY").countryName(Country.MYANMAR).tax(Tax.builder().taxCode("MYR").taxPercentage(5).build()).build();
        warehouse = Warehouse.builder().id(ID).name(WH_DESC).company(company).build();
    }

    @Test
    void findAllWarehouse() {
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(warehouse);
        when(warehouseRepository.findAll()).thenReturn(warehouseList);
        assertEquals(1, warehouseService.findAllWarehouse().size());
    }

    @Test
    void findWarehouseById() throws ResourceNotFoundException {
        when(warehouseRepository.findById(ID)).thenReturn(Optional.of(warehouse));
        assertEquals(ID, warehouseService.findWarehouseById(ID).getId());
    }

    @Test
    void saveOrUpdateWarehouse() {
        warehouse.setName(WH_DESC_2);
        when(warehouseRepository.save(any(Warehouse.class))).thenReturn(warehouse);
        WarehouseDto tempWarehouse = warehouseService.saveOrUpdateWarehouse(warehouseMapper.warehouseToWarehouseDTO(warehouse));
        assertEquals(WH_DESC_2, tempWarehouse.getName());
     //   assertEquals("Some expected message", new NullPointerException().getMessage());
    }

    @Test
    void deleteWarehouseById() throws ResourceNotFoundException {
        warehouseService.deleteWarehouseById(ID);
        verify(warehouseRepository, times(1)).deleteById(ID);
    }
}