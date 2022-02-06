package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAllCompany();
    Company findCompanyById(Long id);
    Company saveOrUpdateCompany(Company company);
    void deleteCompanyById(Long id);
}
