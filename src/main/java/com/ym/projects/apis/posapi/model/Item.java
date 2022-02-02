package com.ym.projects.apis.posapi.model;

import com.sun.istack.Nullable;
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

    @Column(name="item_barcode", length = DESCRIPTION_LENGTH)
    private String itemBarCode;

    @Column(name="description", nullable = false , length = DESCRIPTION_LENGTH)
    private String description;

    @Column(name="price" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double sellingPrice;

    @Column(name="cost_price"  , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double costPrice;

    @OneToOne
    @JoinColumn(name = "brand_id", nullable = true)
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "item_type_id")
    private ItemType itemType;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @OneToOne
    @JoinColumn(name = "uom_id")
    private UnitOfMeasure unitOfMeasure;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;


    @Column(name="quantity" , columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private double quantity;

    @Builder

    public Item(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String itemBarCode, String description, double sellingPrice, double costPrice, Brand brand, ItemType itemType, byte[] image, UnitOfMeasure unitOfMeasure, Location location, double quantity) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.itemBarCode = itemBarCode;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        this.brand = brand;
        this.itemType = itemType;
        this.image = image;
        this.unitOfMeasure = unitOfMeasure;
        this.location = location;
        this.quantity = quantity;
    }
}
