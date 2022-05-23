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

import br.anhembi.spring01.model.Consultas;
import br.anhembi.spring01.model.User;
import br.anhembi.spring01.repository.ConsultasRepo;
import br.anhembi.spring01.repository.UserRepo;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {
    
    @Autowired //injeção de independencia
    private ConsultasRepo repo; 
    @Autowired
    private UserRepo userRepo;

    //get all
    @GetMapping
    public ResponseEntity <List<Consultas>> findAll(){
        List<Consultas> listconsultas = (List<Consultas>) repo.findAll();
        return ResponseEntity.ok(listconsultas);
    }

    @GetMapping("/userConsultas/{codUser}")
    public ResponseEntity<List<Consultas>> findMedicosByTipoExame(@PathVariable long codUser){
        List<Consultas> listaConsultas = (List<Consultas>) repo.findAll();
        
        List<Consultas> consultasFiltradas = new ArrayList<Consultas>();

        for(Consultas c : listaConsultas){
            if(c.getCodeUser() == codUser){
                consultasFiltradas.add(c);
            }
        }

        if(!consultasFiltradas.isEmpty()){
            return ResponseEntity.ok(consultasFiltradas);
        }

        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/{codeUser}")
    public ResponseEntity<Consultas> insertResultadoConsultaWithConsulta(@PathVariable long codeUser, @RequestBody Consultas consulta){
        User user = userRepo.findById(codeUser).orElse(null);

        if(user != null){
            Consultas newConsultas = repo.save(consulta);
            newConsultas.setCodeUser(codeUser);
            newConsultas = repo.save(newConsultas);
            return ResponseEntity.status(HttpStatus.CREATED).body(newConsultas);
        }

        return ResponseEntity.notFound().build();
    }

}
