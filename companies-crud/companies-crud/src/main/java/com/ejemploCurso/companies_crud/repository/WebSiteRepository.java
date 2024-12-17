package com.ejemploCurso.companies_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemploCurso.companies_crud.entities.WebSite;

public interface WebSiteRepository extends JpaRepository<WebSite, Long> {

}
