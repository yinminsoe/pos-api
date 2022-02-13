package com.ym.projects.apis.posapi.entity;

import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

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
@SQLDelete(sql = "UPDATE brand SET record_status = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Brand extends BaseEntityWithName {
    @Column(name = "brand_type")
    private String brandType;

    @Builder
    public Brand(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, RecordStatus recordStatus, String name, String brandType) {
        super(id, createDate, createBy, updateDate, updateBy, recordStatus, name);
        this.brandType = brandType;
    }
}
