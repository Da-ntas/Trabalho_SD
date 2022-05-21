package br.anhembi.spring01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.Consultas;
import br.anhembi.spring01.repository.ConsultasRepo;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {
    
    @Autowired //injeção de independencia
    private ConsultasRepo repo; 

    //get all
    @GetMapping
    public ResponseEntity <List<Consultas>> findAll(){
        List<Consultas> listconsultas = (List<Consultas>) repo.findAll();
        return ResponseEntity.ok(listconsultas);
    }
}
