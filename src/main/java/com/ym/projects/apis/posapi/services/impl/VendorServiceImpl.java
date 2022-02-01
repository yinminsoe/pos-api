package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.model.Vendor;
import com.ym.projects.apis.posapi.repositories.VendorRepository;
import com.ym.projects.apis.posapi.services.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<Vendor> findAllVendor() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor findVendorById(Long id) {
        return vendorRepository.findById(id).get();
    }

    @Override
    public Vendor saveOrUpdateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.deleteById(id);
    }
}
