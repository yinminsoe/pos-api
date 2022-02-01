package com.ym.projects.apis.posapi.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="location")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Location extends BaseEntity{
    @Column(name ="description", nullable = false, length = DESCRIPTION_LENGTH)
    private String description;

    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Builder
    public Location(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String description, Warehouse warehouse) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.warehouse = warehouse;
    }
}
