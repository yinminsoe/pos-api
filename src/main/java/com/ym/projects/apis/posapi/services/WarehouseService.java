package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.entity.Warehouse;
import com.ym.projects.apis.posapi.exception.ResourceNotFoundException;

import java.util.List;

public interface WarehouseService {
    List<WarehouseDto> findAllWarehouse();
    WarehouseDto findWarehouseById(Long id) ;
    WarehouseDto saveOrUpdateWarehouse(WarehouseDto warehouseDto) ;
    void deleteWarehouseById(Long id) ;
    boolean existsById(Long id) ;
    boolean existsById(Long id, String action);
}
