package com.ym.projects.apis.posapi.repositories;

import com.ym.projects.apis.posapi.model.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure,Long> {
}
