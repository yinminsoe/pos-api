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
public class WarehouseDtoList extends BaseDtoList{
    @JsonProperty("warehouseList")
    private List<WarehouseDto> warehouseDtoList = new ArrayList<WarehouseDto>();
}
