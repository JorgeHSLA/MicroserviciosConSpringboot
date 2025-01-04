package com.ejemploCurso.companies_crud.services;


import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ejemploCurso.companies_crud.entities.Category;
import com.ejemploCurso.companies_crud.entities.Company;
import com.ejemploCurso.companies_crud.repository.CompanyRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional // rollback
@Slf4j // hace que no sea necesario instanciar un logger
@AllArgsConstructor // crea un constructor con todos los argumentos
public class CompanyServiceImplement implements CompanyService{

    //@Autowired no es necesario por el @AllArgsConstructor 
    private final CompanyRepository companyRepository;

    @Override
    public Company readByName(String name){
        return this.companyRepository.findByName(name)
        .orElseThrow(()-> new NoSuchElementException("Company not found"));
    }
        
    

    @Override
    public Company create(Company company) {
        company.getWebSites().forEach(website-> {if (Objects.isNull(website.getCategory())){
            website.setCategory(Category.NONE);
        }});
        
        return this.companyRepository.save(company);
    }

    @Override
    public Company update(Company company, String name) {
        var companyToUpdate = companyRepository.findByName(name)
            .orElseThrow(()-> new NoSuchElementException("Company not found"));
        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFounder(company.getFounder());
        companyToUpdate.setFoundationDate(company.getFoundationDate());

        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(String name) {
        var companyToDelete = companyRepository.findByName(name)
            .orElseThrow(()-> new NoSuchElementException("Company not found"));
        this.companyRepository.delete(companyToDelete);
    }

}
