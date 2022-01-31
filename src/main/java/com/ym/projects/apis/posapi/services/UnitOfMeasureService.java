package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.model.UnitOfMeasure;

import java.util.List;

public interface UnitOfMeasureService {
    List<UnitOfMeasure> findAllUnitOfMeasure();
    UnitOfMeasure findUnitOfMeasureById(Long id);
    UnitOfMeasure saveAndUpdateUnitOfMeasure(UnitOfMeasure unitOfMeasure);
    void deleteUnitOfMeasureById(Long id);
}
