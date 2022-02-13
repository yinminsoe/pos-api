package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.dto.LocationDto;
import com.ym.projects.apis.posapi.entity.Location;
import com.ym.projects.apis.posapi.exception.ResourceNotFoundException;
import com.ym.projects.apis.posapi.mapper.LocationMapper;
import com.ym.projects.apis.posapi.repositories.LocationRepository;
import com.ym.projects.apis.posapi.services.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LocationServiceImpl extends BaseAbstractService implements LocationService {

    private final LocationMapper locationMapper;
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationMapper locationMapper, LocationRepository locationRepository) {
        this.locationMapper = locationMapper;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationDto> findAllLocation() {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDto findLocationById(Long id) {
        Optional<Location> locationOptional=locationRepository.findById(id);
        if(locationOptional.isPresent()){
            return locationMapper.toDto(locationOptional.get());
        }else
        {
            throw new ResourceNotFoundException(getMessageWithPlaceHolder("loc.not.found", new String[] {String.valueOf(id)}));
        }
    }

    @Override
    public LocationDto saveOrUpdateLocation(LocationDto locationDto) {
        Long id = locationDto.getId();
        if(id != null && id > 0){
            //old
            if(existsById(id, "action.update")){
                return locationMapper.toDto(locationRepository.save(locationMapper.toEntity(locationDto)));
            }else{
                return null;
            }
        }else{
            //new
            return locationMapper.toDto(locationRepository.save(locationMapper.toEntity(locationDto)));
        }

    }


    @Override
    public void deleteLocationById(Long id) {
        if(existsById(id, "action.delete")) {
            locationRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return locationRepository.existsById(id);
    }

    @Override
    public boolean existsById(Long id, String action) {
        //existsById
        if (!this.existsById(id)) {
            throw new ResourceNotFoundException(getMessageWithPlaceHolder("loc.not.found", new String[]{String.valueOf(id), getMessage(action)}));
        } else{
            return true;
        }
    }
}
