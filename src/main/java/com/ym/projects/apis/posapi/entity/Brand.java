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
@Table(name = "brand")
public class Brand extends BaseEntityWithName {
    @Column(name = "brand_type")
    private String brandType;

    @Builder
    public Brand(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name, String brandType) {
        super(id, createDate, createBy, updateDate, updateBy, name);
        this.brandType = brandType;
    }
}
