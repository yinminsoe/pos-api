package com.ym.projects.apis.posapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class Address {
    private String address1;

    private String address2;

}
