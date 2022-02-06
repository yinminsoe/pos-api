package com.ym.projects.apis.posapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_company"))
    private Company company;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "role", length = ENUM_TYPE_LENGTH)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private Person person;

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

    @Builder
    public Employee(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, Company company, String userId, Role role, Person person, Address address, Phone phone) {
        super(id, createDate, createBy, updateDate, updateBy);
        this.company = company;
        this.userId = userId;
        this.role = role;
        this.person = person;
        this.address = address;
        this.phone = phone;
    }
}
