package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.UnitOfMeasure;
import com.ym.projects.apis.posapi.repositories.UnitOfMeasureRepository;
import com.ym.projects.apis.posapi.services.UnitOfMeasureService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UnitOfMeasureServiceImplTest extends BaseTestCase {

    private static UnitOfMeasure unitOfMeasure;
    private static final String BASE_UOM = "PCS";
    private static final float BASE_RATE = 1f;

    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;

    private UnitOfMeasureService unitOfMeasureService;

    @BeforeEach
    void setUp(){
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository);
        unitOfMeasure = UnitOfMeasure.builder().id(ID).name(BASE_UOM).description("Pieces").baseUOM(BASE_UOM).rateToBase(BASE_RATE).build();
    }

    @Test
    void findAllUnitOfMeasure() {
        List<UnitOfMeasure> unitOfMeasureList = new ArrayList<>();
        unitOfMeasureList.add(unitOfMeasure);
        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasureList);
        assertEquals(unitOfMeasureList.size(), unitOfMeasureService.findAllUnitOfMeasure().size());
    }

    @Test
    void findUnitOfMeasureById() {
        when(unitOfMeasureRepository.findById(ID)).thenReturn(Optional.of(unitOfMeasure));
        assertEquals(ID, unitOfMeasureService.findUnitOfMeasureById(ID).getId());
    }

    @Test
    void saveAndUpdateUnitOfMeasure() {
        ArgumentCaptor<UnitOfMeasure> captor = ArgumentCaptor.forClass(UnitOfMeasure.class);
        unitOfMeasureService.saveAndUpdateUnitOfMeasure(unitOfMeasure);
        verify(unitOfMeasureRepository, times(1)).save(captor.capture());
        assertEquals(ID,captor.getValue().getId());
    }

    @Test
    void deleteUnitOfMeasureById() {
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        unitOfMeasureService.deleteUnitOfMeasureById(ID);
        verify(unitOfMeasureRepository, times(1)).deleteById(captor.capture());
        assertEquals(ID,  captor.getValue());

    }
}