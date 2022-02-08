package com.ym.projects.apis.posapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto extends RepresentationModel<BaseDto>  implements Serializable {
    private static final long serialVersionUID = 1L;


    protected static final int NAME_LENGTH = 70;
    protected static final String ALL_PRICE_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";
    protected static final String ALL_QTY_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";
    protected static final int ADDRESS_LENGTH = 120;
    protected static final int PHONE_LENGTH = 20;
    protected static final int ENUM_TYPE_LENGTH = 20;
    protected static final int USER_LENGTH = 20;

    private Long id;
    private LocalDateTime createDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;

}
