package com.ym.projects.apis.posapi.mapper;

import com.ym.projects.apis.posapi.dto.BaseDto;
import com.ym.projects.apis.posapi.entity.BaseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface BaseDtoMapper {
    BaseEntity dtoToEntity(BaseDto baseDto);

    BaseDto entityToDto(BaseEntity baseEntity);
}
