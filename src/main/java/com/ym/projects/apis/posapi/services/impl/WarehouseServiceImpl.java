package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.model.Warehouse;
import com.ym.projects.apis.posapi.repositories.WarehouseRepository;
import com.ym.projects.apis.posapi.services.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> findAllWarehouse() {
        log.debug("findAllWarehouse");
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse findWarehouseById(Long id) {
        return warehouseRepository.findById(id).get();
    }

    @Override
    public Warehouse saveAndUpdateWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteWarehouseById(Long id) {
        warehouseRepository.deleteById(id);
    }
}
