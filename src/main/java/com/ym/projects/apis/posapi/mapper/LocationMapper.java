package com.ym.projects.apis.posapi.mapper;

import com.ym.projects.apis.posapi.dto.LocationDto;
import com.ym.projects.apis.posapi.entity.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    @Mapping(source = "entity.warehouse.id", target="warehouseId")
    LocationDto toDto(Location entity);

    @Mapping(source="dto.warehouseId", target="warehouse.id")
    Location toEntity(LocationDto dto);
}
