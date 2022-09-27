package com.example.survey.controller;

import com.example.survey.model.Company;
import com.example.survey.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

    @Autowired
    CompanyRepo companyRepository;

    @GetMapping("/companies")
    public List<Company> getCompanyName() {
        return companyRepository.findAll();
    }

    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@RequestBody Company companyDetails) {

        companyDetails = companyRepository.save(companyDetails);
        return new ResponseEntity<Company>(companyDetails, HttpStatus.OK);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company companyDetails) {
        Company updateCompany = null;
        Optional<Company> companyOptional = companyRepository.findById(companyDetails.getId());

        if (companyOptional.isPresent()) {
            updateCompany = companyOptional.get();
            updateCompany.setName(companyDetails.getName());
            updateCompany.setAddress(companyDetails.getAddress());
            companyRepository.save(updateCompany);
        }
        return ResponseEntity.ok(updateCompany);
    }
}
