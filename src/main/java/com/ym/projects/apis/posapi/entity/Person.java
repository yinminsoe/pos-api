package com.ym.projects.apis.posapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Person {
    protected static final int NAME_LENGTH = 30;
    @Column(name = "first_name", length = NAME_LENGTH)
    private String firstName;

    @Column(name = "middle_name", length = NAME_LENGTH)
    private String middleName;

    @Column(name = "last_name", length = NAME_LENGTH)
    private String lastName;


}
