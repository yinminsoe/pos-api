package com.ym.projects.apis.posapi.repositories;

import com.ym.projects.apis.posapi.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
