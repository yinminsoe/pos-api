package com.ym.projects.apis.posapi.repositories;

import com.ym.projects.apis.posapi.entity.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
}
