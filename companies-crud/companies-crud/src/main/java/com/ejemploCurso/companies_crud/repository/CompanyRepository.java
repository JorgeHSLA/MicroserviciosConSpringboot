package com.ejemploCurso.companies_crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemploCurso.companies_crud.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

        Optional<Company> findByName(String name);
    
}
