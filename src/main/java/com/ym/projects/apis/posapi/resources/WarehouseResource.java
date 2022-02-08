package com.ym.projects.apis.posapi.resources;

import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.dto.WarehouseDtoList;
import com.ym.projects.apis.posapi.exception.ResourceNotFoundException;
import com.ym.projects.apis.posapi.services.WarehouseService;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/warehouse")
public class WarehouseResource extends BaseResource {
    private final WarehouseService warehouseService;


    public WarehouseResource(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public WarehouseDtoList getAllWarehouses(){
        WarehouseDtoList warehouseDtoList = new WarehouseDtoList();
        warehouseDtoList.setWarehouseDtoList(warehouseService.findAllWarehouse());

        for (WarehouseDto whDto: warehouseDtoList.getWarehouseDtoList()) {
            // Adding self link warehouse 'singular' resource
            Link link = linkTo(WarehouseResource.class)
                    .slash(whDto.getId()).withSelfRel();
            whDto.add(link);
        }
        // Adding self link employee collection resource
        Link selfLink =
                linkTo(methodOn(WarehouseResource.class).getAllWarehouses())
                        .withSelfRel();

        // Add link to collection resource
        warehouseDtoList.add(selfLink);

        return warehouseDtoList;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WarehouseDto getWarehouseById(@PathVariable("id")Long id) throws ResourceNotFoundException {
        WarehouseDto warehouseDto= warehouseService.findWarehouseById(id);

        // Self link
        Link selfLink = linkTo(WarehouseResource.class)
                .slash(warehouseDto.getId()).withSelfRel();
        warehouseDto.add(selfLink);
        return  warehouseDto;
    }

    @PostMapping
    public ResponseEntity<WarehouseDto> saveWarehouse(@Valid @RequestBody WarehouseDto warehouseDto) {
         WarehouseDto warehouseDtoSavedResult= warehouseService.saveOrUpdateWarehouse(warehouseDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(WarehouseResource.class).slash(warehouseDtoSavedResult.getId()).toUri());
        // Self link
        Link selfLink = linkTo(WarehouseResource.class)
                .slash(warehouseDtoSavedResult.getId()).withSelfRel();
        warehouseDtoSavedResult.add(selfLink);
        return new ResponseEntity<WarehouseDto>(warehouseDtoSavedResult, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseDto> saveOrUpdateWarehouse(@PathVariable Long id, @RequestBody WarehouseDto warehouseDto) {
        warehouseDto.setId(id);
        WarehouseDto warehouseDtoSavedResult= warehouseService.saveOrUpdateWarehouse(warehouseDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(WarehouseResource.class).slash(id).toUri());
        // Self link
        Link selfLink = linkTo(WarehouseResource.class)
                .slash(id).withSelfRel();
        warehouseDtoSavedResult.add(selfLink);
        return new ResponseEntity<WarehouseDto>(warehouseDtoSavedResult, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWarehouseById(@PathVariable("id")Long id) throws ResourceNotFoundException {
        warehouseService.deleteWarehouseById(id);
    }
}
