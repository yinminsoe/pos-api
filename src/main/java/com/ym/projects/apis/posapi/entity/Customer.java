package com.ym.projects.apis.posapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseEntityWithName {

    @Column(name = "contact_name2", nullable = true)
    private String contactName2;

    @Column(name = "company_name", nullable = false)
    private String companyName;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column = @Column(name = "home_address", length = ADDRESS_LENGTH)),
            @AttributeOverride(name = "address2", column = @Column(name = "delivery_address", length = ADDRESS_LENGTH))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phone1", column = @Column(name = "mobile_phone", length = PHONE_LENGTH)),
            @AttributeOverride(name = "phone2", column = @Column(name = "secondary_phone", length = PHONE_LENGTH)),
            @AttributeOverride(name = "phone3", column = @Column(name = "home_phone", length = PHONE_LENGTH))
    })
    private Phone phone;

    @Column(name = "credit_limit", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double creditLimit;

    @Builder
    public Customer(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name, String contactName2, String companyName, Address address, Phone phone, double creditLimit) {
        super(id, createDate, createBy, updateDate, updateBy, name);
        this.contactName2 = contactName2;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.creditLimit = creditLimit;
    }
}
