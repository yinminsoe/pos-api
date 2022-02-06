package com.ym.projects.apis.posapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Tax {
    private String taxCode;
    private int taxPercentage;
    private double taxValue;
}
