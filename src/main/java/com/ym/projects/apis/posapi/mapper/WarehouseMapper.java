package com.ym.projects.apis.posapi.mapper;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.entity.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
 public interface WarehouseMapper  {
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    @Mapping(source = "entity.company.id" , target = "companyId")
    WarehouseDto toDto(Warehouse entity);

    @Mapping(source = "dto.companyId" , target = "company.id")
    Warehouse toEntity(WarehouseDto dto);
}
