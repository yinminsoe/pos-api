package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="item_type")
public class ItemType extends BaseEntity{

    @Column(name="description", nullable = false, length = DESCRIPTION_LENGTH)
    private String description;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_type_item_category"))
    private ItemCategory itemCategory;

    @Builder
    public ItemType(Long id, LocalDateTime CreateDate, String CreateBy, LocalDateTime UpdateDate, String UpdateBy, String description, ItemCategory itemCategory) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.itemCategory = itemCategory;
    }
}
