package com.ym.projects.apis.posapi.controllers;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.services.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WarehouseDto> getAllWarehouse(){
        return warehouseService.findAllWarehouse();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WarehouseDto getWarehouseById(@PathVariable("id")Long id){
        return warehouseService.findWarehouseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WarehouseDto saveOrUpdateWarehouse(@RequestBody WarehouseDto warehouseDto){
        return warehouseService.saveOrUpdateWarehouse(warehouseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWarehouseById(@PathVariable("id")Long id){
        warehouseService.deleteWarehouseById(id);
    }
}
