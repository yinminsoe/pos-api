package com.ym.projects.apis.posapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "item_type")
public class ItemType extends BaseEntityWithName {

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_type_item_category"))
    private ItemCategory itemCategory;

    @Builder
    public ItemType(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name, ItemCategory itemCategory) {
        super(id, createDate, createBy, updateDate, updateBy, name);
        this.itemCategory = itemCategory;
    }
}
