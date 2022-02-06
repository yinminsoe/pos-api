package com.ym.projects.apis.posapi.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="location")
public class Location extends BaseEntity{
    @Column(name ="description", nullable = false, length = DESCRIPTION_LENGTH)
    private String description;

    @OneToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_location_warehouse"))
    private Warehouse warehouse;

    @Builder
    public Location(Long id, LocalDateTime CreateDate, String CreateBy, LocalDateTime UpdateDate, String UpdateBy, String description, Warehouse warehouse) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.warehouse = warehouse;
    }
}
