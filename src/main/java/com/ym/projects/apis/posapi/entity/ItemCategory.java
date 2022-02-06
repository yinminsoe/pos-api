package com.ym.projects.apis.posapi.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "item_category")
public class ItemCategory extends BaseEntityWithName {

    public ItemCategory() {
    }

    @Builder
    public ItemCategory(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name) {
        super(id, createDate, createBy, updateDate, updateBy, name);
    }
}
