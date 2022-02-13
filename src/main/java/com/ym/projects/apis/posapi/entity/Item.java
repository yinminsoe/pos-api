package com.ym.projects.apis.posapi.entity;

import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "item")
@SQLDelete(sql = "UPDATE item SET record_status = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Item extends BaseEntityWithName {

    @OneToOne
    @JoinColumn(name = "brand_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_brand"))
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "item_type_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_item_type"))
    private ItemType itemType;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_location"))
    private Location location;


    @OneToOne
    @JoinColumn(name = "uom_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_uom"))
    private UnitOfMeasure unitOfMeasure;

    @Column(name = "item_barcode", length = NAME_LENGTH)
    private String itemBarCode;


    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "quantity", columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private double quantity;

    @Column(name = "price", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double sellingPrice;

    @Column(name = "cost_price", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double costPrice;

    @Builder

    public Item(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, RecordStatus recordStatus, String name, Brand brand, ItemType itemType, Location location, UnitOfMeasure unitOfMeasure, String itemBarCode, byte[] image, double quantity, double sellingPrice, double costPrice) {
        super(id, createDate, createBy, updateDate, updateBy, recordStatus, name);
        this.brand = brand;
        this.itemType = itemType;
        this.location = location;
        this.unitOfMeasure = unitOfMeasure;
        this.itemBarCode = itemBarCode;
        this.image = image;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }
}
