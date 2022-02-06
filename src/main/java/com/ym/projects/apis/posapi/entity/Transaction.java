package com.ym.projects.apis.posapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction", indexes = {
        @Index(name = "idx_employee_transaction_date", columnList = "employee_id, transaction_date"),
        @Index(name = "idx_customer_transaction_date", columnList = "customer_id, transaction_date"),
        @Index(name = "idx_create_date", columnList = "create_date", unique = true)
})
public class Transaction extends BaseEntity {

    @CreationTimestamp
    @Column(name = "transaction_date")
    private LocalDate transactionDate;


    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_transaction_employee"))
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "fk_transaction_customer"))
    private Customer customer;

    @Column(name = "total_transaction", columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private int total_transaction;

    @Column(name = "total_quantity", columnDefinition = ALL_QTY_COLUMN_DEFINITION)
    private int total_quantity;

    @Column(name = "total_amount", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double totalAmount;

    @Column(name = "total_discount", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private float headerDiscount;

    @Column(name = "total_payment", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double totalPayment;

    @Column(name = "change_amount", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double changeAmount;

    @Column(name = "sub_total", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double subTotal;

    @Column(name = "total_cost", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double totalCostAmount;


    @Column(name = "total_profit", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double totalProfit;

    @Column(name = "payment_type", length = ENUM_TYPE_LENGTH)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    private Set<TransactionDetails> transactionDetails;

    @Column(name = "transaction_type", length = ENUM_TYPE_LENGTH)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;


    @Column(name = "transaction_status", length = ENUM_TYPE_LENGTH)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction))
            return false;
        Transaction other = (Transaction) o;
        return this.getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return (int) (this.getId() * this.getEmployee().getId().hashCode());
    }

    @Builder

    public Transaction(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, LocalDate transactionDate, Employee employee, Customer customer, int total_transaction, int total_quantity, double totalAmount, float headerDiscount, double totalPayment, double changeAmount, double subTotal, double totalCostAmount, double totalProfit, PaymentType paymentType, Set<TransactionDetails> transactionDetails, TransactionType transactionType, TransactionStatus transactionStatus) {
        super(id, createDate, createBy, updateDate, updateBy);
        this.transactionDate = transactionDate;
        this.employee = employee;
        this.customer = customer;
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
    }
}
