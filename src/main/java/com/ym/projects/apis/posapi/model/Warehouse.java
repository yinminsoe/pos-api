package com.ym.projects.apis.posapi.model;

import com.ym.projects.apis.posapi.repositories.WarehouseRepository;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="warehouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Warehouse extends BaseEntity{

    @Column(name ="name", nullable = false)
    private String name;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "warehouse")
    private Location location;

    @Builder
    public Warehouse(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String name, Location location) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.name = name;
        this.location = location;
    }
}
