package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Vendor extends BaseEntity{
    @Column(name = "contact_name1", nullable = false)
    private String contactName1;

    @Column(name = "contact_name2", nullable = true)
    private String contactName2;

    @Column(name ="company_name", nullable = false)
    private String companyName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column =  @Column(name = "address_1", length = ADDRESS_LENGTH)),
            @AttributeOverride(name = "address2", column = @Column( name = "address_2", length = ADDRESS_LENGTH))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="phone1", column = @Column( name = "primary_phone", length = PHONE_LENGTH)),
            @AttributeOverride(name = "phone2", column = @Column( name ="secondary_phone", length = PHONE_LENGTH)),
            @AttributeOverride( name="phone3", column = @Column(name="fax_no", length = PHONE_LENGTH))
    })
    private Phone phone;

    @Column(name ="credit_limit")
    private double creditLimit;

    @Builder
    public Vendor(Long id, LocalDateTime CreateDate, String CreateBy, LocalDateTime UpdateDate, String UpdateBy, String contactName1, String contactName2, String companyName, Address address, Phone phone, double creditLimit) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.contactName1 = contactName1;
        this.contactName2 = contactName2;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.creditLimit = creditLimit;
    }
}
