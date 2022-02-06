package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.mapper.WarehouseMapper;
import com.ym.projects.apis.posapi.model.Warehouse;
import com.ym.projects.apis.posapi.repositories.WarehouseRepository;
import com.ym.projects.apis.posapi.services.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseMapper warehouseMapper;
    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseMapper warehouseMapper, WarehouseRepository warehouseRepository) {
        this.warehouseMapper = warehouseMapper;
        this.warehouseRepository = warehouseRepository;
    }



    @Override
    public List<WarehouseDto> findAllWarehouse() {
        log.debug("findAllWarehouse");
        return warehouseRepository.findAll()
                .stream()
                .map(warehouseMapper::warehouseToWarehouseDTO)
                .collect(Collectors.toList());

    }


    @Override
    public WarehouseDto findWarehouseById(Long id) {
        Optional<Warehouse> optionalWarehouse=warehouseRepository.findById(id);
        if(optionalWarehouse.isPresent()){
            return warehouseMapper.warehouseToWarehouseDTO(optionalWarehouse.get());
        }
        return null;
    }

    @Override
    public WarehouseDto saveOrUpdateWarehouse(WarehouseDto warehouseDto) {
        return warehouseMapper.warehouseToWarehouseDTO(warehouseRepository.save(warehouseMapper.warehouseDtoToWarehouse(warehouseDto)));
    }

    @Override
    public void deleteWarehouseById(Long id) {
        warehouseRepository.deleteById(id);
    }
}
