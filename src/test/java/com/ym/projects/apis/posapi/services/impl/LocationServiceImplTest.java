package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.entity.Location;
import com.ym.projects.apis.posapi.entity.Warehouse;
import com.ym.projects.apis.posapi.repositories.LocationRepository;
import com.ym.projects.apis.posapi.services.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LocationServiceImplTest extends BaseTestCase {
    private final String WH_DESC = "WAREHOUSE 1";
    private final String LOC_DESC = "LOCATION 1";
    private final String LOC_DESC_2 = "LOCATION 2";

    @Mock
    private LocationRepository locationRepository;
    private LocationService locationService;
    private Location location;

    @BeforeEach
    void setUp() {
        locationService = new LocationServiceImpl(locationRepository);
        location=Location.builder().id(ID).name(LOC_DESC).build();
        Warehouse warehouse = Warehouse.builder().id(ID).name(WH_DESC).build();
        location.setWarehouse(warehouse);
    }
    @Test
    void findAllLocation() {
        List<Location> locationList= new ArrayList<>();
        locationList.add(location);
        when(locationRepository.findAll()).thenReturn(locationList);
        assertEquals(locationList.size(), locationService.findAllLocation().size());
    }

    @Test
    void findLocationById() {
        when(locationRepository.findById(ID)).thenReturn(Optional.of(location));
        assertEquals(location.getId(), locationService.findLocationById(ID).getId());

    }

    @Test
    void saveOrUpdateLocation() {
        when(locationRepository.save(location)).thenReturn(location);
        assertEquals(location.getId(), locationService.saveOrUpdateLocation(location).getId());
    }

    @Test
    void deleteLocationById() {
        locationService.deleteLocationById(ID);
        verify(locationRepository, times(1)).deleteById(ID);
    }
}