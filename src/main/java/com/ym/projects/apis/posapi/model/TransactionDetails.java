package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="transaction_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class TransactionDetails {
    private static final String ALL_PRICE_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";
    private static final String ALL_QTY_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "line_no",  columnDefinition = "DECIMAL(5,0) DEFAULT 0")
    private int lineNo;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @OneToOne
    @JoinColumn(name ="item_id")
    private Item item;

    @OneToOne
    @JoinColumn(name = "uom_id")
    private UnitOfMeasure uom;

    @Column(name = "quantity" , columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private int quantity;

    @Column(name="foc")
    private boolean foc;

    @Column(name="discount_price"  , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float discountPrice;

    @Column(name="transaction_price"  , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float transactionPrice;

    @Column(name="cos_price" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float costOfGoodsSold;

    @Column(name="profit_amount" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float profitAmount;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransactionDetails))
            return false;
        TransactionDetails other = (TransactionDetails)o;
        return this.getId() == other.getId();
    }
}
