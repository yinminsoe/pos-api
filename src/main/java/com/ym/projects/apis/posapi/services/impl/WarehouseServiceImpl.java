package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.exception.ResourceNotFoundException;
import com.ym.projects.apis.posapi.mapper.WarehouseMapper;
import com.ym.projects.apis.posapi.entity.Warehouse;
import com.ym.projects.apis.posapi.repositories.WarehouseRepository;
import com.ym.projects.apis.posapi.services.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WarehouseServiceImpl extends BaseAbstractService implements WarehouseService {

    private final WarehouseMapper warehouseMapper;
    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseMapper warehouseMapper, WarehouseRepository warehouseRepository) {
        this.warehouseMapper = warehouseMapper;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<WarehouseDto> findAllWarehouse() {
        return warehouseRepository.findAll()
                .stream()
                .map(warehouseMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public WarehouseDto findWarehouseById(Long id) {
        Optional<Warehouse> optionalWarehouse=warehouseRepository.findById(id);
        if(optionalWarehouse.isPresent()){
            return warehouseMapper.toDto(optionalWarehouse.get());
        }else{
            throw new ResourceNotFoundException(getMessageWithPlaceHolder("wh.not.found", new String[]{String.valueOf(id),""}));
        }
    }

    @Override
    public WarehouseDto saveOrUpdateWarehouse(WarehouseDto warehouseDto) {
        Long id = warehouseDto.getId();
        if (id != null && id > 0) {
            //old
            if(existsById(id, "action.update")){
                return warehouseMapper.toDto(warehouseRepository.save(warehouseMapper.toEntity(warehouseDto)));
            }
            else{
               return null;
            }
        }else{
            //new
            return warehouseMapper.toDto(warehouseRepository.save(warehouseMapper.toEntity(warehouseDto)));
        }
    }

    @Override
    public void deleteWarehouseById(Long id) {
        if(existsById(id, "action.delete")){
            warehouseRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return warehouseRepository.existsById(id);
    }

    @Override
    public boolean existsById(Long id, String action) {
        //existsById
        if (!this.existsById(id)) {
            throw new ResourceNotFoundException(getMessageWithPlaceHolder("wh.not.found", new String[]{String.valueOf(id), getMessage(action)}));
        } else{
            return true;
        }
    }
}
