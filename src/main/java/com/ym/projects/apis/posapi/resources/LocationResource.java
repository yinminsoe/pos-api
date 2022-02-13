package com.ym.projects.apis.posapi.resources;

import com.ym.projects.apis.posapi.dto.LocationDto;
import com.ym.projects.apis.posapi.dto.LocationDtoList;
import com.ym.projects.apis.posapi.exception.ResourceNotFoundException;
import com.ym.projects.apis.posapi.services.LocationService;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/location")
public class LocationResource  extends BaseResource {
    private LocationService locationService;

    public LocationResource(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public LocationDtoList getAllLocation() {
        LocationDtoList locationDtoList = new LocationDtoList();
        locationDtoList.setLocationDtoList(locationService.findAllLocation());

        for (LocationDto locationDto : locationDtoList.getLocationDtoList()) {
            // Adding self link location 'singular' resource
            Link selfLocLink = linkTo(LocationResource.class)
                    .slash(locationDto.getId()).withSelfRel();
            locationDto.add(selfLocLink);
        }
        // Adding self link location collection resource
        Link selfLink = linkTo(methodOn(LocationResource.class).getAllLocation()).withSelfRel();
        locationDtoList.add(selfLink);

        return locationDtoList;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationDto getLocationById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        LocationDto locationDto = locationService.findLocationById(id);
        Link selfLink = linkTo(LocationResource.class).slash(locationDto.getId()).withSelfRel();
        locationDto.add(selfLink);
        return locationDto;
    }

    @PostMapping
    public ResponseEntity<LocationDto> saveLocation(@Valid @RequestBody LocationDto locationDto) {
        locationDto.setId(null);
        LocationDto savedLocationDto = locationService.saveOrUpdateLocation(locationDto);
        HttpHeaders headers = new HttpHeaders();
        Link selfLink = linkTo(LocationResource.class).slash(savedLocationDto.getId()).withSelfRel();
        headers.setLocation(selfLink.toUri());
        savedLocationDto.add(selfLink);
        return new ResponseEntity<LocationDto>(savedLocationDto, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable("id") Long id, @Valid @RequestBody LocationDto locationDto) {
        locationDto.setId(id);
        LocationDto savedLocationDto = locationService.saveOrUpdateLocation(locationDto);
        HttpHeaders headers = new HttpHeaders();
        Link selfLink = linkTo(LocationResource.class).slash(savedLocationDto.getId()).withSelfRel();
        headers.setLocation(selfLink.toUri());
        savedLocationDto.add(selfLink);
        return new ResponseEntity<LocationDto>(savedLocationDto, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteLocationById(@PathVariable("id") Long id) throws ResourceNotFoundException{
        locationService.deleteLocationById(id);
    }
}