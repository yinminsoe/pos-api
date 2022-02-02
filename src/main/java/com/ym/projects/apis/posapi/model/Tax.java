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
public class Tax {
    private String taxCode;
    private int taxPercentage;
    private double taxValue;


}
