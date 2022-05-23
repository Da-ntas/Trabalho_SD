package br.anhembi.spring01.controller;

import java.util.ArrayList;
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

import br.anhembi.spring01.model.Medicos;
import br.anhembi.spring01.model.TipoExame;
import br.anhembi.spring01.repository.MedicosRepo;
import br.anhembi.spring01.repository.TipoExameRepo;

@RestController
@RequestMapping("/medicos")
public class MedicosController {
    
    @Autowired //injeção de independencia
    private MedicosRepo repo; 
    @Autowired 
    private TipoExameRepo tipoExameRepo;

    //get all
    @GetMapping
    public ResponseEntity <List<Medicos>> findAll(){
        List<Medicos> listmedicos = (List<Medicos>) repo.findAll();
        return ResponseEntity.ok(listmedicos);
    }

    @GetMapping("/tipoExame/{codTipoExame}")
    public ResponseEntity<List<Medicos>> findMedicosByTipoExame(@PathVariable long codTipoExame){
        List<Medicos> listaMedicos = (List<Medicos>) repo.findAll();

        List<Medicos> medicosFiltrados = new ArrayList<Medicos>();
        
        for(Medicos m : listaMedicos){
            if(m.getCodTipoExame() == codTipoExame){
                medicosFiltrados.add(m);      
            }
        }

        if(!medicosFiltrados.isEmpty()){
            return ResponseEntity.ok(medicosFiltrados);
        }

        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/{code}")
    public ResponseEntity<Medicos> insertResultadoConsultaWithConsulta(@PathVariable long code, @RequestBody Medicos medico){
        TipoExame tipoExame = tipoExameRepo.findById(code).orElse(null);

        if(tipoExame != null){
            Medicos newMedicos = repo.save(medico);
            newMedicos.setCodTipoExame(code);
            newMedicos = repo.save(newMedicos);
            return ResponseEntity.status(HttpStatus.CREATED).body(newMedicos);
        }

        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<Medicos> insertMedicos(@RequestBody Medicos medico){

        Medicos newMedicos = repo.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMedicos);
    }
}
