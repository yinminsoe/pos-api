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
@Table(name="item_category")
public class ItemCategory extends BaseEntity{
    @Column(name="description", nullable = false, length = DESCRIPTION_LENGTH)
    private String description;

    @Builder
    public ItemCategory(Long id, LocalDateTime CreateDate, String CreateBy, LocalDateTime UpdateDate, String UpdateBy, String description) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
    }
}
