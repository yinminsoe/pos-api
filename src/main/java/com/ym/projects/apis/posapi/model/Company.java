package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Company extends BaseEntity{
    @Column(name ="description", nullable = false)
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(name ="country_name")
    private Country country;

    @Column(name="license_no")
    private String licenseNo;

    @Column(name="license_no_2")
    private String licenseNo2;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "address1", column = @Column(name = "address_1", length = ADDRESS_LENGTH)),
            @AttributeOverride( name = "address2", column = @Column(name = "address_2", length = ADDRESS_LENGTH))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name ="phone1", column = @Column(name = "phone_1", length = PHONE_LENGTH)),
            @AttributeOverride( name="phone2", column = @Column(name = "phone_2", length = PHONE_LENGTH)),
            @AttributeOverride( name="phone3", column = @Column(name="phone_3", length = PHONE_LENGTH))
    })
    private Phone phone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="taxCode", column = @Column(name = "tax_code", length = 10)),
            @AttributeOverride(name ="taxPercentage", column = @Column(name = "tax_percentage", columnDefinition = "DECIMAL(3,0) DEFAULT 0")),
            @AttributeOverride(name ="taxValue", column = @Column(name = "tax_value", columnDefinition = "DECIMAL(7,2) DEFAULT 0.00"))
    })
    private Tax tax;
    @Builder

    public Company(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, String description, Country country, String licenseNo, String licenseNo2, Address address, Phone phone, Tax tax) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.description = description;
        this.country = country;
        this.licenseNo = licenseNo;
        this.licenseNo2 = licenseNo2;
        this.address = address;
        this.phone = phone;
        this.tax = tax;
    }
}