package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.Brand;
import com.ym.projects.apis.posapi.repositories.BrandRepository;
import com.ym.projects.apis.posapi.services.BrandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BrandServiceImplTest extends BaseTestCase {
    private Brand brand;
    private final String DESC_1 = "Brand Description 1";

    @Mock
    private BrandRepository brandRepository;
    private BrandService brandService;


    @BeforeEach
    void setUp() {
        brandService = new BrandServiceImpl(brandRepository);
        brand = Brand.builder().id(ID).description(DESC_1).build();

    }

    @Test
    void findAllBrand() {
        List<Brand> brandList = new ArrayList<>();
        brandList.add(brand);
        when(brandRepository.findAll()).thenReturn(brandList);
        assertEquals(brandList.size(), brandService.findAllBrand().size());
    }

    @Test
    void findBrandById() {
        when(brandRepository.findById(ID)).thenReturn(Optional.of(brand));
        assertEquals(ID, brandService.findBrandById(ID).getId());
    }

    @Test
    void saveOrUpdateBrand() {
        ArgumentCaptor<Brand> captor = ArgumentCaptor.forClass(Brand.class);
        brandService.saveOrUpdateBrand(brand);
        verify(brandRepository, times(1)).save(captor.capture());
        assertEquals(brand.getId(), captor.getValue().getId());
    }

    @Test
    void deleteBrandById() {
        brandService.deleteBrandById(ID);
        verify(brandRepository,times(1)).deleteById(ID);
    }
}