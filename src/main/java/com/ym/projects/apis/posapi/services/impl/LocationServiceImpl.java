package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.model.Location;
import com.ym.projects.apis.posapi.repositories.LocationRepository;
import com.ym.projects.apis.posapi.services.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Location findLocationById(Long id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public Location saveAndUpdateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocationById(Long id) {
        locationRepository.deleteById(id);
    }
}
