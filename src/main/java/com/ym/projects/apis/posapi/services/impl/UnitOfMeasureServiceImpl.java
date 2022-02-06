package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.entity.UnitOfMeasure;
import com.ym.projects.apis.posapi.repositories.UnitOfMeasureRepository;
import com.ym.projects.apis.posapi.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public List<UnitOfMeasure> findAllUnitOfMeasure() {
        return unitOfMeasureRepository.findAll();
    }

    @Override
    public UnitOfMeasure findUnitOfMeasureById(Long id) {
        return unitOfMeasureRepository.findById(id).get();
    }

    @Override
    public UnitOfMeasure saveOrUpdateUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        return unitOfMeasureRepository.save(unitOfMeasure);
    }

    @Override
    public void deleteUnitOfMeasureById(Long id) {
        unitOfMeasureRepository.deleteById(id);
    }
}
