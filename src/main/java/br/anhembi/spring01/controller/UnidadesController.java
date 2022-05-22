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

import br.anhembi.spring01.model.Unidades;
import br.anhembi.spring01.repository.UnidadeRepo;

@RestController
@RequestMapping("/unidades")
public class UnidadesController {
    
    @Autowired //injeção de independencia
    private UnidadeRepo repo; 

    //get all
    @GetMapping
    public ResponseEntity <List<Unidades>> findAll(){
        List<Unidades> listuser = (List<Unidades>) repo.findAll();
        return ResponseEntity.ok(listuser);
    }

    @PostMapping
    public ResponseEntity<Unidades> insertUser(@RequestBody Unidades unidade){

        Unidades newUnidade = repo.save(unidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUnidade);
    }

}

