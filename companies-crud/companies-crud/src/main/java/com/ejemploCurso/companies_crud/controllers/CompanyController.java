package com.ejemploCurso.companies_crud.controllers;


import java.net.URI;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemploCurso.companies_crud.entities.Company;
import com.ejemploCurso.companies_crud.services.CompanyService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController // se usa para decir que es un controlador REST, es decir a traves de HTTP hace GET POSTPUT o DELETE
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping(path = "{name}") //Es una anotación de Spring que indica que este método maneja solicitudes HTTP del tipo GET.
    ResponseEntity<Company> get(@PathVariable String name) throws NoSuchFieldException{ //Si alguien accede a /company/Google, el valor "Google" se pasa al parámetro name.
        log.info("GET:company {}",name); // mensaje que indica queu todo esta bien
        return ResponseEntity.ok(this.companyService.readByName(name)); //Crea una respuesta HTTP con el estado 200 OK, lo que esta en el ok es lo que devuelve, en este caso una compania con el nombre name
    }

    @PostMapping
    ResponseEntity<Company> post(@RequestBody  Company company){ //request body es un json que se cambia (en este caso) a tipo Company
         log.info("POST:company {}",company.getName()); 
        return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build(); // se cra la URI ej:/Google

    }
    
    @PutMapping(path = "{name}") //Es una anotación de Spring que indica que este método maneja solicitudes HTTP del tipo GET.
    ResponseEntity<Company> put(@RequestBody  Company company ,@PathVariable String name) throws NoSuchFieldException{ //Si alguien accede a /company/Google, el valor "Google" se pasa al parámetro name.
        log.info("PUT:company {}",name); // mensaje que indica queu todo esta bien
        return ResponseEntity.ok(this.companyService.update(company, name)); //Crea una respuesta HTTP con el estado 200 OK, lo que esta en el ok es lo que devuelve, en este caso una compania con el nombre name
    }

    @DeleteMapping(path = "{name}") 
    ResponseEntity<?> delete(@PathVariable String name){//la interrogacion significa quese puede devolver cualquier objeto 

        log.info("DELETE:company {}",name);
        return ResponseEntity.noContent().build();
    } 

}
