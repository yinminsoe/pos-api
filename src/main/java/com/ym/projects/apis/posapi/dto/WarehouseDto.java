package com.ym.projects.apis.posapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = false)
public class WarehouseDto extends BaseDto {
    private String name;
    private Long companyId;

    @Builder
    public WarehouseDto(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name, Long companyId) {
        super(id, createDate, createBy, updateDate, updateBy);
        this.name = name;
        this.companyId = companyId;
    }
}
