package com.ym.projects.apis.posapi.mapper;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.entity.Company;
import com.ym.projects.apis.posapi.entity.Country;
import com.ym.projects.apis.posapi.entity.Tax;
import com.ym.projects.apis.posapi.entity.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseMapperTest extends BaseTestCase {
    private WarehouseMapper warehouseMapper = WarehouseMapper.INSTANCE;
    private Company company;
    private Warehouse warehouse;
    private WarehouseDto warehouseDto;

    private final String WH_DESC = "WAREHOUSE 1";

    @BeforeEach
    void setUp() {
        company = Company.builder().id(ID2).name("YMS YGN COMPANY").countryName(Country.MYANMAR).tax(Tax.builder().taxCode("MYR").taxPercentage(5).build()).build();
        warehouse = Warehouse.builder().id(ID).name(WH_DESC).company(company).build();
        warehouseDto = WarehouseDto.builder().id(ID).name(WH_DESC).companyId(ID2).build();
    }

    @Test
    void toDto() {
        warehouseDto = warehouseMapper.toDto(warehouse);
        assertEquals(warehouseDto.getId(), warehouse.getId());
        assertEquals(warehouseDto.getName(), warehouse.getName());
        assertEquals(warehouseDto.getCompanyId(), warehouse.getCompany().getId());
    }

    @Test
    void toEntity() {
        warehouse = warehouseMapper.toEntity(warehouseDto);
        assertEquals(warehouse.getId(), warehouseDto.getId());
        assertEquals(warehouse.getName(), warehouseDto.getName());
        assertEquals(warehouse.getCompany().getId(), warehouseDto.getCompanyId());
    }
}