package com.ym.projects.apis.posapi.repositories;

import com.ym.projects.apis.posapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
