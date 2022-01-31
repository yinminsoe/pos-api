package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="uom")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UnitOfMeasure extends BaseEntity{
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="base_uom")
    private String baseUOM;

    @Column(name="rate_to_base")
    private float rateToBase;

    @Builder

    public UnitOfMeasure(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String name, String description, String baseUOM, float rateToBase) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.name = name;
        this.description = description;
        this.baseUOM = baseUOM;
        this.rateToBase = rateToBase;
    }
}

