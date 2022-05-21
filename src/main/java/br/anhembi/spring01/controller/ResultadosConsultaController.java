package br.anhembi.spring01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
