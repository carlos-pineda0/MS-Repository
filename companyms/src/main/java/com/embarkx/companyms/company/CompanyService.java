package com.embarkx.companyms.company;

import com.embarkx.companyms.company.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company findById(Long id);

    void createCompany(Company company);

    boolean updateCompany(Long id, Company company);

    boolean deleteCompany(Long id);

    void updateCompanyRating(ReviewMessage reviewMessage);
}
