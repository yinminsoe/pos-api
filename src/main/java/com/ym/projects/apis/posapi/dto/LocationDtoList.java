package com.ym.projects.apis.posapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDtoList extends BaseDtoList{
    @JsonProperty("locations")
    private List<LocationDto> locationDtoList = new ArrayList<LocationDto>();

}
