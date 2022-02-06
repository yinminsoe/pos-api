package com.ym.projects.apis.posapi.dto;

import com.ym.projects.apis.posapi.model.Company;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
public class WarehouseDto extends BaseDto {
    private String description;
    private Company company;

    @Builder
    public WarehouseDto(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String description, Company company) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.company = company;
    }
}
