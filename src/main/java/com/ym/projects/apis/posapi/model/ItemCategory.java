package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="item_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemCategory extends BaseEntity{
    @Column(name="description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "itemCategory")
    private Item item;

    @Builder
    public ItemCategory(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String description, Item item) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.item = item;
    }
}
