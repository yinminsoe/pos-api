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
    @Embedded
    private Person person;

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
    public Customer(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, Person person, Address address, Phone phone, double creditLimit) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.person = person;
        this.address = address;
        this.phone = phone;
        this.creditLimit = creditLimit;
    }
}
