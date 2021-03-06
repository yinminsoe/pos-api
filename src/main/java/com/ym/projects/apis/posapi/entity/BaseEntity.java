package com.ym.projects.apis.posapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Where(clause = "record_status <> 'DELETED'")
public class BaseEntity implements Serializable {

    protected static final int NAME_LENGTH = 70;
    protected static final String ALL_PRICE_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";
    protected static final String ALL_QTY_COLUMN_DEFINITION = "DECIMAL(12,2) DEFAULT 0.00";
    protected static final int ADDRESS_LENGTH = 120;
    protected static final int PHONE_LENGTH = 20;
    protected static final int ENUM_TYPE_LENGTH = 20;
    protected static final int USER_LENGTH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "create_by", length = USER_LENGTH)
    private String createBy;

    @Column(name = "update_date")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column(name = "update_by", length = USER_LENGTH)
    private String updateBy;

    @Column(name="record_status", columnDefinition =  "VARCHAR2(15) DEFAULT 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;

    @PrePersist
    public void saveRecord(){
       if(!EnumUtils.isValidEnum(RecordStatus.class, String.valueOf(recordStatus))) {
           this.recordStatus = RecordStatus.ACTIVE;
       }
    }

    @PreRemove
    public void deleteRecord() {
        this.recordStatus = RecordStatus.DELETED;
    }
}
