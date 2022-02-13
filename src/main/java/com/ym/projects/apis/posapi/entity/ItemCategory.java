package com.ym.projects.apis.posapi.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "item_category")
@SQLDelete(sql = "UPDATE item_category SET record_status = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class ItemCategory extends BaseEntityWithName {

    public ItemCategory() {
    }

    @Builder
    public ItemCategory(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, RecordStatus recordStatus, String name) {
        super(id, createDate, createBy, updateDate, updateBy, recordStatus, name);
    }
}
