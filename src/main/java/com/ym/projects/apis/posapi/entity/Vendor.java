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
@Table(name = "vendor")
@SQLDelete(sql = "UPDATE vendor SET record_status = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Vendor extends BaseEntityWithName {

    @Column(name = "contact_name2", nullable = true)
    private String contactName2;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column = @Column(name = "address_1", length = ADDRESS_LENGTH)),
            @AttributeOverride(name = "address2", column = @Column(name = "address_2", length = ADDRESS_LENGTH))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phone1", column = @Column(name = "primary_phone", length = PHONE_LENGTH)),
            @AttributeOverride(name = "phone2", column = @Column(name = "secondary_phone", length = PHONE_LENGTH)),
            @AttributeOverride(name = "phone3", column = @Column(name = "fax_no", length = PHONE_LENGTH))
    })
    private Phone phone;

    @Column(name = "credit_limit")
    private double creditLimit;

    @Builder

    public Vendor(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, RecordStatus recordStatus, String name, String contactName2, String companyName, Address address, Phone phone, double creditLimit) {
        super(id, createDate, createBy, updateDate, updateBy, recordStatus, name);
        this.contactName2 = contactName2;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.creditLimit = creditLimit;
    }
}
