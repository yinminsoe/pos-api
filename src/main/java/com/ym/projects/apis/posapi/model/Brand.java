package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode(callSuper = false)
public class Brand extends BaseEntity{
    @Column(name = "brand_type")
    private String brandType;

    @Column(name ="description")
    private String description;

    @Builder
    public Brand(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String brandType, String description) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.brandType = brandType;
        this.description = description;
    }
}
