package com.ym.projects.apis.posapi.mapper;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.dto.LocationDto;
import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationMapperTest extends BaseTestCase {
    private LocationMapper locationMapper=LocationMapper.INSTANCE;
    private final String WH_DESC = "WAREHOUSE 1";
    private final String LOC_DESC = "LOCATION 1";
    private final String LOC_DESC_2 = "LOCATION 2";
    private Company company;
    private Warehouse warehouse;
    private Location location;
    private LocationDto locationDto;


    @BeforeEach
    void setUp() {
        company = Company.builder().id(ID2).name("YMS YGN COMPANY").countryName(Country.MYANMAR).tax(Tax.builder().taxCode("MYR").taxPercentage(5).build()).build();
        warehouse = Warehouse.builder().id(ID).name(WH_DESC).company(company).build();
        location=Location.builder().id(ID).name(LOC_DESC).build();
        Warehouse warehouse = Warehouse.builder().id(ID).name(WH_DESC).build();
        location.setWarehouse(warehouse);

        locationDto=LocationDto.builder().id(ID).name(LOC_DESC).build();
        locationDto.setWarehouseId(warehouse.getId());
    }

    @Test
    void toDto() {
        locationDto = locationMapper.toDto(location);
        assertEquals(location.getId(), locationDto.getId());
        assertEquals(location.getName(), locationDto.getName());
        assertEquals(location.getWarehouse().getId(), locationDto.getWarehouseId());
    }

    @Test
    void toEntity() {
        location = locationMapper.toEntity(locationDto);
        assertEquals(locationDto.getId(), location.getId());
        assertEquals(locationDto.getName(), location.getName());
        assertEquals(locationDto.getWarehouseId(), location.getWarehouse().getId());

    }

}