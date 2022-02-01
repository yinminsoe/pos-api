package com.ym.projects.apis.posapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
@EqualsAndHashCode(callSuper = false)
public class Employee extends BaseEntity{

    @Embedded
    private Person person;

    @Column(name = "role", length = ENUM_TYPE_LENGTH)
    @Enumerated(EnumType.STRING)
    private Role role;

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

    @Builder
    public Employee(Long id, Date CreateDate, String CreateBy, Date UpdateDate, String UpdateBy, Person person, Role role, Address address, Phone phone) {
        super(id, CreateDate, CreateBy, UpdateDate, UpdateBy);
        this.person = person;
        this.role = role;
        this.address = address;
        this.phone = phone;
    }
}
