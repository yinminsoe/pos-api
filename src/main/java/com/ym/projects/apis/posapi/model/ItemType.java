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

    @Column(name="description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "itemType")
    private Item item;

    @Builder
    public ItemType(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String description, Item item) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.item = item;
    }
}
