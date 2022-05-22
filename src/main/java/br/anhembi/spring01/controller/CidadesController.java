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

import br.anhembi.spring01.model.Cidades;
import br.anhembi.spring01.repository.CidadesRepo;

@RestController
@RequestMapping("/cidades")
public class CidadesController {
    
    @Autowired //injeção de independencia
    private CidadesRepo repo; 

    //get all
    @GetMapping
    public ResponseEntity <List<Cidades>> findAll(){
        List<Cidades> listcidades = (List<Cidades>) repo.findAll();
        return ResponseEntity.ok(listcidades);
    }

    
    @PostMapping
    public ResponseEntity<Cidades> insertCidades(@RequestBody Cidades cidades){

        Cidades newcidade = repo.save(cidades);
        return ResponseEntity.status(HttpStatus.CREATED).body(newcidade);
    }
}
