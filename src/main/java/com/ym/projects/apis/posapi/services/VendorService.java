package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.model.Vendor;

import java.util.List;

public interface VendorService {
    List<Vendor> findAllVendor();
    Vendor findVendorById(Long id);
    Vendor saveOrUpdateVendor(Vendor vendor);
    void deleteVendorById(Long id);
}
