package com.ejemploCurso.companies_crud.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


//http://localhost:8081/companies-crud/swagger-ui/index.html#/ 
//este link es para obsebar el swagger del microservicio


@Configuration 
@OpenAPIDefinition(
    info = @Info(
        title = "companies CRUD",
        version =  "1.0.0", 
        description =  "This is a CRUD for managment companies" 
    ) 
)
public class OpenApiConfig {

}
