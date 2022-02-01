package com.ym.projects.apis.posapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class Phone {
    private String phone1;
    private String phone2;
    private String phone3;
}
