package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.exception.ResourceNotFoundException;

import java.util.List;

public interface WarehouseService {
    List<WarehouseDto> findAllWarehouse();
    WarehouseDto findWarehouseById(Long id) throws ResourceNotFoundException;
    WarehouseDto saveOrUpdateWarehouse(WarehouseDto warehouseDto) ;
    void deleteWarehouseById(Long id) throws ResourceNotFoundException ;

}
