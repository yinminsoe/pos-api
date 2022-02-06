package com.ym.projects.apis.posapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transaction_details", indexes = {
        @Index(name = "idx_tranaction_line_no", columnList = "transaction_id, line_no", unique = true)
})
public class TransactionDetails {
    private static final String ALL_PRICE_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";
    private static final String ALL_QTY_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line_no", columnDefinition = "DECIMAL(5,0) DEFAULT 0")
    private int lineNo;

    @ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_transaction_details_transaction"))
    private Transaction transaction;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_transaction_details_item"))
    private Item item;

    @OneToOne
    @JoinColumn(name = "uom_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_transaction_details_uom"))
    private UnitOfMeasure uom;

    @Column(name = "quantity", columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private int quantity;

    @Column(name = "foc")
    private boolean foc;

    @Column(name = "discount_price", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float discountPrice;

    @Column(name = "transaction_price", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float transactionPrice;

    @Column(name = "cos_price", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float costOfGoodsSold;

    @Column(name = "profit_amount", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float profitAmount;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransactionDetails))
            return false;
        TransactionDetails other = (TransactionDetails) o;
        return this.getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return (int) (this.getId() * Long.valueOf(this.getLineNo()).hashCode());
    }
}
