package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.model.Warehouse;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> findAllWarehouse();
    Warehouse findWarehouseById(Long id);
    Warehouse saveAndUpdateWarehouse(Warehouse warehouse);
    void deleteWarehouseById(Long id);
}
