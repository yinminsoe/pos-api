package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="item_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemType extends BaseEntity{

    @Column(name="description", nullable = false, length = DESCRIPTION_LENGTH)
    private String description;

    @OneToOne
    @JoinColumn(name = "category_id")
    private ItemCategory itemCategory;

    @Builder
    public ItemType(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String description, ItemCategory itemCategory) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.itemCategory = itemCategory;
    }
}
