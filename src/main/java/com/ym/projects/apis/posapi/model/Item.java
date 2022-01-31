package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Item extends BaseEntity{
    @Column(name="description")
    private String description;

    @Column(name="price")
    private double sellingPrice;

    @Column(name="cost_price")
    private double costPrice;

    @OneToOne
    @JoinColumn(name = "category_id")
    private ItemCategory itemCategory;

    @OneToOne
    @JoinColumn(name = "type_id")
    private ItemType itemType;


    @OneToOne
    @JoinColumn(name = "uom_id")
    private UnitOfMeasure unitOfMeasure;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Column(name="quantity")
    private double quantity;

    @Builder
    public Item(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String description, double sellingPrice, double costPrice, ItemCategory itemCategory, ItemType itemType, UnitOfMeasure unitOfMeasure, Location location, Warehouse warehouse, double quantity) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        this.itemCategory = itemCategory;
        this.itemType = itemType;
        this.unitOfMeasure = unitOfMeasure;
        this.location = location;
        this.warehouse = warehouse;
        this.quantity = quantity;
    }
}
