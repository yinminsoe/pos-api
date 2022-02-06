package com.ym.projects.apis.posapi.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Slf4j
@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseEntityWithName {

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_warehouse_company"))
    private Company company;

    @Builder
    public Warehouse(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name, Company company) {
        super(id, createDate, createBy, updateDate, updateBy, name);
        this.company = company;
    }
}
