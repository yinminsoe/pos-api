package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseEntity{
    @Column(name = "contact_name1", nullable = false)
    private String contactName1;

    @Column(name = "contact_name2", nullable = true)
    private String contactName2;

    @Column(name ="company_name", nullable = false)
    private String companyName;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "address1", column = @Column(name = "home_address", length = ADDRESS_LENGTH)),
            @AttributeOverride( name = "address2", column = @Column(name = "delivery_address", length = ADDRESS_LENGTH))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name ="phone1", column = @Column(name = "mobile_phone", length = PHONE_LENGTH)),
            @AttributeOverride( name="phone2", column = @Column(name = "secondary_phone", length = PHONE_LENGTH)),
            @AttributeOverride( name="phone3", column = @Column(name="home_phone", length = PHONE_LENGTH))
    })
    private Phone phone;

    @Column(name="credit_limit", columnDefinition = ALL_PRICE_COLUMN_DEFINITION)
    private double creditLimit;

    @Builder
    public Customer(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String contactName1, String contactName2, String companyName, Address address, Phone phone, double creditLimit) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.contactName1 = contactName1;
        this.contactName2 = contactName2;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.creditLimit = creditLimit;
    }
}
