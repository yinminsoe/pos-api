package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.entity.Address;
import com.ym.projects.apis.posapi.entity.Phone;
import com.ym.projects.apis.posapi.entity.Vendor;
import com.ym.projects.apis.posapi.repositories.VendorRepository;
import com.ym.projects.apis.posapi.services.VendorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class VendorServiceImplTest extends BaseTestCase {
    private Vendor vendor;

    @Mock
    private VendorRepository vendorRepository;

    private VendorService vendorService;

    @BeforeEach
    void setUp() {
        vendorService = new VendorServiceImpl(vendorRepository);
        vendor = Vendor.builder()
                .id(ID)
                .name("CONATCT NAME 1").contactName2("CONTACT NAME 2")
                .address(Address.builder().address1("Address 1").address2("Address 2").build())
                .phone(Phone.builder().phone1("Phone 1").phone2("Phone 2").phone3("Phone 3").build())
                .creditLimit(0L).build();
    }


    @Test
    void findAllVendor() {
        List<Vendor> vendorList = new ArrayList<>();
        vendorList.add(vendor);
        BDDMockito.given(vendorRepository.findAll()).willReturn(vendorList);
        vendorService.findAllVendor();
        BDDMockito.then(vendorRepository).should(times(1)).findAll();

    }

    @Test
    void findVendorById() {
        BDDMockito.given(vendorRepository.findById(ID)).willReturn(Optional.of(vendor));
        vendorService.findVendorById(ID);
        BDDMockito.then(vendorRepository).should(times(1)).findById(ID);
    }

    @Test
    void saveOrUpdateVendor() {
        BDDMockito.given(vendorRepository.save(vendor)).willReturn(vendor);
        vendorService.saveOrUpdateVendor(vendor);
        BDDMockito.then(vendorRepository).should(times(1)).save(vendor);

    }

    @Test
    void deleteVendorById() {
        vendorService.deleteVendorById(ID);
        verify(vendorRepository, times(1)).deleteById(ID);
    }
}