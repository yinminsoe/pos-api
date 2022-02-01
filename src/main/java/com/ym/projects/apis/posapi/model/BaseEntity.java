package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract  class BaseEntity  implements Serializable {

    protected static final int DESCRIPTION_LENGTH=70;
    protected static final String ALL_PRICE_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";
    protected static final String ALL_QTY_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";
    protected static final int ADDRESS_LENGTH = 120;
    protected static final int PHONE_LENGTH = 20;
    protected static final int ENUM_TYPE_LENGTH = 20;
    protected static final int USER_LENGTH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "create_date")
    private Date CreateDate;

    @Column(name = "create_by", length = USER_LENGTH)
    private String CreateBy;

    @Column(name = "update_date")
    private Date UpdateDate;

    @Column(name = "update_by", length = USER_LENGTH)
    private String UpdateBy;

}
