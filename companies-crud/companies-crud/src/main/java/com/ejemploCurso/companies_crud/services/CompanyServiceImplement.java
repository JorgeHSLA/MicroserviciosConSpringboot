package com.ejemploCurso.companies_crud.services;

import org.springframework.stereotype.Service;

import com.ejemploCurso.companies_crud.entities.Company;

import jakarta.transaction.Transactional;

@Service
@Transactional // roll back
public class CompanyServiceImplement implements CompanyService{


    @Override
    public Company readByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByName'");
    }

    @Override
    public Company create(Company company) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Company update(Company company, String newName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
