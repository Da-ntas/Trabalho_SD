package br.anhembi.spring01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.Medicos;
import br.anhembi.spring01.repository.MedicosRepo;

@RestController
@RequestMapping("/medicos")
public class MedicosController {
    
    @Autowired //injeção de independencia
    private MedicosRepo repo; 

    //get all
    @GetMapping
    public ResponseEntity <List<Medicos>> findAll(){
        List<Medicos> listmedicos = (List<Medicos>) repo.findAll();
        return ResponseEntity.ok(listmedicos);
    }

    
    @PostMapping
    public ResponseEntity<Medicos> insertMedicos(@RequestBody Medicos medico){

        Medicos newMedicos = repo.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMedicos);
    }
}
