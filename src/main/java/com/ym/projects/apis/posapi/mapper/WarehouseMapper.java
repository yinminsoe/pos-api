package com.ym.projects.apis.posapi.mapper;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.model.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {BaseDtoMapper.class})
public interface WarehouseMapper {
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    //@Mapping(source = "company.id" , target = "companyId")
    WarehouseDto warehouseToWarehouseDTO(Warehouse warehouse);

   // @Mapping(source = "companyId" , target = "company.id")
    Warehouse warehouseDtoToWarehouse(WarehouseDto warehouse);
}
