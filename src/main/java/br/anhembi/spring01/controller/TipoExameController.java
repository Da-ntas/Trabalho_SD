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

import br.anhembi.spring01.model.TipoExame;
import br.anhembi.spring01.repository.TipoExameRepo;

@RestController
@RequestMapping("/tipoexames")
public class TipoExameController {
    @Autowired //injeção de independencia
    private TipoExameRepo repo; 

    //get all
    @GetMapping
    public ResponseEntity <List<TipoExame>> findAll(){
        List<TipoExame> listTipoExame = (List<TipoExame>) repo.findAll();
        return ResponseEntity.ok(listTipoExame);
    }

    
    @PostMapping
    public ResponseEntity<TipoExame> insertTiposExames(@RequestBody TipoExame tipoexame){

        TipoExame newTipoExame = repo.save(tipoexame);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTipoExame);
    }

}
