package com.ym.projects.apis.posapi.dto;

import com.ym.projects.apis.posapi.entity.RecordStatus;
import com.ym.projects.apis.posapi.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto extends BaseDto{
    @NotBlank(message = "Name is mandatory")
    @Size(max=NAME_LENGTH)
    private String name;

    @NotNull
    private Long warehouseId;

    @Builder

    public LocationDto(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, RecordStatus recordStatus, @NotBlank(message = "Name is mandatory") @Size(max = NAME_LENGTH) String name, @NotNull Long warehouseId) {
        super(id, createDate, createBy, updateDate, updateBy, recordStatus);
        this.name = name;
        this.warehouseId = warehouseId;
    }
}
