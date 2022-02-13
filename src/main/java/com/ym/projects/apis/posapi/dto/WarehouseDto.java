package com.ym.projects.apis.posapi.dto;

import com.ym.projects.apis.posapi.entity.Location;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
public class WarehouseDto extends BaseDto {
    @NotBlank(message = "Name is mandatory")
    @Size(max=NAME_LENGTH)
    private String name;

    @NotNull
    private Long companyId;

    @Builder
    public WarehouseDto(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, @NotBlank(message = "Name is mandatory") @Size(max = NAME_LENGTH) String name, @NotNull Long companyId) {
        super(id, createDate, createBy, updateDate, updateBy);
        this.name = name;
        this.companyId = companyId;
    }
}
