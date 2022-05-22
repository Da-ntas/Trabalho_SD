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

import br.anhembi.spring01.model.ResultadosConsulta;
import br.anhembi.spring01.repository.ResultadosConsultaRepo;

@RestController
@RequestMapping("/resultadoconsulta")
public class ResultadosConsultaController {
    
    @Autowired //injeção de independencia
    private ResultadosConsultaRepo repo; 

    //get all
    @GetMapping
    public ResponseEntity <List<ResultadosConsulta>> findAll(){
        List<ResultadosConsulta> listResultadosConsulta = (List<ResultadosConsulta>) repo.findAll();
        return ResponseEntity.ok(listResultadosConsulta);
    }

    
    @PostMapping
    public ResponseEntity<ResultadosConsulta> insertResultadosConsultas(@RequestBody ResultadosConsulta resultadoconsulta){

        ResultadosConsulta newresultadoconsulta = repo.save(resultadoconsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(newresultadoconsulta);
    }
}
