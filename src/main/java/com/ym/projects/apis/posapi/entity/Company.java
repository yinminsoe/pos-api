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
@Table(name = "company")
@SQLDelete(sql = "UPDATE company SET record_status = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Company extends BaseEntityWithName {

    @Enumerated(EnumType.STRING)
    private Country countryName;

    @Column(name = "license_no")
    private String licenseNo;

    @Column(name = "license_no_2")
    private String licenseNo2;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column = @Column(name = "address_1", length = ADDRESS_LENGTH)),
            @AttributeOverride(name = "address2", column = @Column(name = "address_2", length = ADDRESS_LENGTH))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phone1", column = @Column(name = "phone_1", length = PHONE_LENGTH)),
            @AttributeOverride(name = "phone2", column = @Column(name = "phone_2", length = PHONE_LENGTH)),
            @AttributeOverride(name = "phone3", column = @Column(name = "fax_no", length = PHONE_LENGTH))
    })
    private Phone phone;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "taxCode", column = @Column(name = "tax_code", length = 10)),
            @AttributeOverride(name = "taxPercentage", column = @Column(name = "tax_percentage", columnDefinition = "DECIMAL(3,0) DEFAULT 0")),
            @AttributeOverride(name = "taxValue", column = @Column(name = "tax_value", columnDefinition = "DECIMAL(7,2) DEFAULT 0.00"))
    })
    private Tax tax;

    @Builder
    public Company(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, RecordStatus recordStatus, String name, Country countryName, String licenseNo, String licenseNo2, Address address, Phone phone, Tax tax) {
        super(id, createDate, createBy, updateDate, updateBy, recordStatus, name);
        this.countryName = countryName;
        this.licenseNo = licenseNo;
        this.licenseNo2 = licenseNo2;
        this.address = address;
        this.phone = phone;
        this.tax = tax;
    }
}
