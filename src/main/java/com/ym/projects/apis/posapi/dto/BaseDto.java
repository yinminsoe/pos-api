package com.ym.projects.apis.posapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto {
    private Long id;
    private Date CreateDate;
    private String CreateBy;
    private Date UpdateDate;
    private String UpdateBy;
}
