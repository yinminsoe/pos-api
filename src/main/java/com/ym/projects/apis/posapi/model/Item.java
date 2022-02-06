package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Item extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "brand_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_brand"))
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "item_type_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_item_item_type"))
    private ItemType itemType;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_location"))
    private Location location;


    @OneToOne
    @JoinColumn(name = "uom_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name ="fk_item_uom"))
    private UnitOfMeasure unitOfMeasure;

    @Column(name="item_barcode", length = DESCRIPTION_LENGTH)
    private String itemBarCode;

    @Column(name="description", nullable = false , length = DESCRIPTION_LENGTH)
    private String description;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name="quantity" , columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private double quantity;

    @Column(name="price" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double sellingPrice;

    @Column(name="cost_price"  , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double costPrice;

    @Builder
    public Item(Long id, LocalDateTime CreateDate, String CreateBy, LocalDateTime UpdateDate, String UpdateBy, Brand brand, ItemType itemType, Location location, UnitOfMeasure unitOfMeasure, String itemBarCode, String description, byte[] image, double quantity, double sellingPrice, double costPrice) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.brand = brand;
        this.itemType = itemType;
        this.location = location;
        this.unitOfMeasure = unitOfMeasure;
        this.itemBarCode = itemBarCode;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }
}
