package com.ym.projects.apis.posapi.repositories;

import com.ym.projects.apis.posapi.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
