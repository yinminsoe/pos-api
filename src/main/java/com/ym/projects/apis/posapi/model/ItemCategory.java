package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="item_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemCategory extends BaseEntity{
    @Column(name="description", nullable = false, length = DESCRIPTION_LENGTH)
    private String description;

    @Builder
    public ItemCategory(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String description) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
    }
}
