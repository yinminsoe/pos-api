package com.ym.projects.apis.posapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntityWithName extends BaseEntity {
    @Column(name = "name", nullable = false, length = NAME_LENGTH)
    private String name;

    public BaseEntityWithName(Long id, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy, String name) {
        super(id, createDate, createBy, updateDate, updateBy);
        this.name = name;
    }

    @PrePersist
    @PreUpdate
    public void preSaveAndUpdate() {
        if (StringUtils.hasLength(name)) {
            name = name.toUpperCase(Locale.ROOT);
        }
    }
}
