package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.entity.UnitOfMeasure;

import java.util.List;

public interface UnitOfMeasureService {
    List<UnitOfMeasure> findAllUnitOfMeasure();
    UnitOfMeasure findUnitOfMeasureById(Long id);
    UnitOfMeasure saveOrUpdateUnitOfMeasure(UnitOfMeasure unitOfMeasure);
    void deleteUnitOfMeasureById(Long id);
}
