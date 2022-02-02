package com.ym.projects.apis.posapi.services;


import com.ym.projects.apis.posapi.model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAllBrand();
    Brand findBrandById(Long id);
    Brand saveOrUpdateBrand(Brand company);
    void deleteBrandById(Long id);
}
