package com.ejemploCurso.companies_crud.services;

import com.ejemploCurso.companies_crud.entities.Company;

public interface CompanyService {

        Company readByName(String name) throws NoSuchFieldException;
        Company create(Company company);
        Company update(Company company, String newName);
        void delete(String name);
    }
