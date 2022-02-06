package com.ym.projects.apis.posapi.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "location")
public class Location extends BaseEntityWithName {


    @OneToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_location_warehouse"))
    private Warehouse warehouse;

    @Builder
    public Location(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name, Warehouse warehouse) {
        super(id, createDate, createBy, updateDate, updateBy, name);
        this.warehouse = warehouse;
    }
}
