package com.ym.projects.apis.posapi.model;

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
@Table(name ="brand")
public class Brand extends BaseEntity{
    @Column(name = "brand_type")
    private String brandType;

    @Column(name ="description")
    private String description;

    @Builder
    public Brand(Long id, LocalDateTime CreateDate, String CreateBy, LocalDateTime UpdateDate, String UpdateBy, String brandType, String description) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.brandType = brandType;
        this.description = description;
    }
}
