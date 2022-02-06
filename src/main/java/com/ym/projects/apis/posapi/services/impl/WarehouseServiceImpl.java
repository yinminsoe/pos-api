package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.exception.ResourceNotFoundException;
import com.ym.projects.apis.posapi.mapper.WarehouseMapper;
import com.ym.projects.apis.posapi.entity.Warehouse;
import com.ym.projects.apis.posapi.repositories.WarehouseRepository;
import com.ym.projects.apis.posapi.services.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WarehouseServiceImpl extends BaseService implements WarehouseService {

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
    public WarehouseDto findWarehouseById(Long id) throws ResourceNotFoundException {
        Optional<Warehouse> optionalWarehouse=warehouseRepository.findById(id);
        if(optionalWarehouse.isPresent()){
            return warehouseMapper.warehouseToWarehouseDTO(optionalWarehouse.get());
        }else{
            throw new ResourceNotFoundException(getMessage("wh.not.found", new String[]{String.valueOf(id),""}));
        }
    }

    @Override
    public WarehouseDto saveOrUpdateWarehouse(WarehouseDto warehouseDto) {
        return warehouseMapper.warehouseToWarehouseDTO(warehouseRepository.save(warehouseMapper.warehouseDtoToWarehouse(warehouseDto)));
    }

    @Override
    public void deleteWarehouseById(Long id) throws ResourceNotFoundException {
        try{
            warehouseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(getMessage("wh.not.found", new String[]{String.valueOf(id), getMessage("action.delete")}));
        }
    }
}
