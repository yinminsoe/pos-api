package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.entity.Brand;
import com.ym.projects.apis.posapi.repositories.BrandRepository;
import com.ym.projects.apis.posapi.services.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findBrandById(Long id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public Brand saveOrUpdateBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);
    }
}
