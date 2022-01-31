package com.ym.projects.apis.posapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract  class BaseStringEntity {
    @Id
    private String id;
    private Date CreateDate;
    private String CreateBy;
    private Date UpdateDate;
    private String UpdateBy;

}
