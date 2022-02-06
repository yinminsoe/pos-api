package com.ym.projects.apis.posapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "uom")
public class UnitOfMeasure extends BaseEntityWithName {
    @Column(name = "short_name", length = 10)
    private String shortName;


    @Column(name = "base_uom", columnDefinition = "VARCHAR(5) DEFAULT '' ")
    private String baseUOM;

    @Column(name = "rate_to_base", columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private float rateToBase;

    @Builder

    public UnitOfMeasure(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name, String shortName, String baseUOM, float rateToBase) {
        super(id, createDate, createBy, updateDate, updateBy, name);
        this.shortName = shortName;
        this.baseUOM = baseUOM;
        this.rateToBase = rateToBase;
    }
}

