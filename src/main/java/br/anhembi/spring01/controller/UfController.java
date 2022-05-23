package br.anhembi.spring01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.Uf;
import br.anhembi.spring01.repository.UfRepo;

@RestController
@RequestMapping("/uf")
public class UfController {
    
    @Autowired //injeção de independencia
    private UfRepo repo; 

    //get all
    @GetMapping
    public ResponseEntity <List<Uf>> findAll(){
        List<Uf> listuser = (List<Uf>) repo.findAll();
        return ResponseEntity.ok(listuser);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Uf> findUF(@PathVariable long id){
        Uf uf = repo.findById(id).orElse(null);
        
        if(uf != null ){
            return ResponseEntity.ok(uf);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping()
    public ResponseEntity<Uf> insertUfs(@RequestBody Uf uf){

        Uf newuf = repo.save(uf);
        return ResponseEntity.status(HttpStatus.CREATED).body(newuf);
    }

}
