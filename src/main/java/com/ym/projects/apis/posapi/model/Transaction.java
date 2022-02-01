package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Transaction extends BaseEntity{


    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @Column(name = "total_transaction" , columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private int total_transaction;

    @Column(name = "total_quantity" , columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private int total_quantity;

    @Column(name="total_amount"  , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double totalAmount;

    @Column(name ="total_discount" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float headerDiscount;

    @Column(name="total_payment" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double totalPayment;

    @Column(name="change_amount" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double changeAmount;

    @Column(name = "sub_total" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double subTotal;

    @Column(name = "total_cost" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double totalCostAmount;


    @Column(name = "total_profit" , columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double totalProfit;

    @Column(name ="payment_type", length = ENUM_TYPE_LENGTH)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;


    @OneToMany( cascade =  CascadeType.ALL, mappedBy = "transaction")
    private Set<TransactionDetails> transactionDetails;

    @Column(name = "transaction_type", length = ENUM_TYPE_LENGTH)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;


    @Column(name = "transaction_status", length = ENUM_TYPE_LENGTH)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @OneToOne
    @JoinColumn(name="customer_id", nullable = true)
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction))
            return false;
        Transaction other = (Transaction)o;
        return this.getId() == other.getId();
    }

    @Builder
    public Transaction(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, Employee employee, int total_transaction, int total_quantity, double totalAmount, float headerDiscount, double totalPayment, double changeAmount, double subTotal, double totalCostAmount, double totalProfit, PaymentType paymentType, Set<TransactionDetails> transactionDetails, TransactionType transactionType, TransactionStatus transactionStatus, Customer customer) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.employee = employee;
        this.total_transaction = total_transaction;
        this.total_quantity = total_quantity;
        this.totalAmount = totalAmount;
        this.headerDiscount = headerDiscount;
        this.totalPayment = totalPayment;
        this.changeAmount = changeAmount;
        this.subTotal = subTotal;
        this.totalCostAmount = totalCostAmount;
        this.totalProfit = totalProfit;
        this.paymentType = paymentType;
        this.transactionDetails = transactionDetails;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.customer = customer;
    }
}
