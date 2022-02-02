package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.Company;
import com.ym.projects.apis.posapi.model.Country;
import com.ym.projects.apis.posapi.model.Tax;
import com.ym.projects.apis.posapi.repositories.CompanyRepository;
import com.ym.projects.apis.posapi.services.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompanyServiceImplTest extends BaseTestCase {
    private Company company;
    @Mock
    private CompanyRepository companyRepository;

    private CompanyService companyService;

    @BeforeEach
    void setUp() {
        company = Company.builder().id(ID).description("YMS YGN COMPANY").country(Country.MY).tax(Tax.builder().taxCode("MYR").taxPercentage(5).build()).build();
        companyService = new CompanyServiceImpl(companyRepository);
    }

    @Test
    void findAllCompany() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(company);
        when(companyRepository.findAll()).thenReturn(companyList);
        assertEquals(companyList.size(), companyService.findAllCompany().size());
        verify(companyRepository, times(1)).findAll();
    }

    @Test
    void findCompanyById() {
        BDDMockito.given(companyRepository.findById(ID)).willReturn(Optional.of(company));
        assertEquals(ID, companyService.findCompanyById(ID).getId());
        BDDMockito.then(companyRepository).should(times(1)).findById(ID);
    }

    @Test
    void saveOrUpdateCompany() {
        BDDMockito.given(companyRepository.save(any(Company.class))).willReturn(company);
        ArgumentCaptor<Company> captor = ArgumentCaptor.forClass(Company.class);
        companyService.saveOrUpdateCompany(company);
        BDDMockito.then(companyRepository).should(times(1)).save(captor.capture());
        assertEquals(ID, captor.getValue().getId());
    }

    @Test
    void deleteCompanyById() {
        companyService.deleteCompanyById(ID);
        verify(companyRepository, times(1)).deleteById(ID);
    }
}