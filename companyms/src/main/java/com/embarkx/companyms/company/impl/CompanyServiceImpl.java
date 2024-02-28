package com.embarkx.companyms.company.impl;

import com.embarkx.companyms.company.Company;
import com.embarkx.companyms.company.CompanyRepository;
import com.embarkx.companyms.company.CompanyService;
import com.embarkx.companyms.company.clients.ReviewClient;
import com.embarkx.companyms.company.dto.ReviewMessage;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private ReviewClient reviewClient;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClient reviewClient) {
        this.companyRepository = companyRepository;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<Company> findAll() {

        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company toUpdate = companyOptional.get();
            // update fields
            toUpdate.setDescription(company.getDescription());
            toUpdate.setName(company.getName());

            companyRepository.save(toUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        System.out.println(reviewMessage.getDescription());
        Company company = companyRepository.findById(reviewMessage.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Company not found " + reviewMessage.getCompanyId()));
        Double averageRatingForCompany = reviewClient.getAverageRatingForCompany(reviewMessage.getCompanyId());
        company.setRating(averageRatingForCompany);
        companyRepository.save(company);
    }
}
