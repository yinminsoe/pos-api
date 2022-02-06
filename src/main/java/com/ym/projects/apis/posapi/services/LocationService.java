package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAllLocation();
    Location findLocationById(Long id);
    Location saveOrUpdateLocation(Location location);
    void deleteLocationById(Long id);
}
