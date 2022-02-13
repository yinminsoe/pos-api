package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.dto.LocationDto;
import com.ym.projects.apis.posapi.entity.Location;

import java.util.List;

public interface LocationService {
    List<LocationDto> findAllLocation();
    LocationDto findLocationById(Long id);
    LocationDto saveOrUpdateLocation(LocationDto locationDto);
    void deleteLocationById(Long id);
    boolean existsById(Long id) ;
    boolean existsById(Long id, String action);
}
