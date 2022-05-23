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

import br.anhembi.spring01.model.Consultas;
import br.anhembi.spring01.model.ResultadosConsulta;
import br.anhembi.spring01.repository.ConsultasRepo;
import br.anhembi.spring01.repository.ResultadosConsultaRepo;

@RestController
@RequestMapping("/resultadoconsulta")
public class ResultadosConsultaController {
    
    @Autowired //injeção de independencia
    private ResultadosConsultaRepo repo; 

    @Autowired
    private ConsultasRepo consultasRepo;

    //get all
    @GetMapping
    public ResponseEntity <List<ResultadosConsulta>> findAll(){
        List<ResultadosConsulta> listResultadosConsulta = (List<ResultadosConsulta>) repo.findAll();
        return ResponseEntity.ok(listResultadosConsulta);
    }

    @GetMapping("/{codeConsulta}")
    public ResponseEntity<ResultadosConsulta> findResultadosConsultaByConsulta(@PathVariable long codeConsulta){
        List<ResultadosConsulta> listResultadoConsulta = (List<ResultadosConsulta>) repo.findAll();
        
        for(ResultadosConsulta rc : listResultadoConsulta){
            if(rc.getCodeConsultas() == codeConsulta){
                return ResponseEntity.ok(rc);
            }
        }

        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/{codeConsulta}")
    public ResponseEntity<ResultadosConsulta> insertResultadoConsultaWithConsulta(@PathVariable long codeConsulta, @RequestBody ResultadosConsulta resultadoConsulta){
        Consultas consulta = consultasRepo.findById(codeConsulta).orElse(null);

        if(consulta != null){
            ResultadosConsulta newResultadoConsulta = repo.save(resultadoConsulta);
            newResultadoConsulta.setCodeConsultas(codeConsulta);
            newResultadoConsulta = repo.save(newResultadoConsulta);
            return ResponseEntity.status(HttpStatus.CREATED).body(newResultadoConsulta);
        }

        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<ResultadosConsulta> insertResultadosConsultas(@RequestBody ResultadosConsulta resultadoconsulta){

        ResultadosConsulta newresultadoconsulta = repo.save(resultadoconsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(newresultadoconsulta);
    }
}
