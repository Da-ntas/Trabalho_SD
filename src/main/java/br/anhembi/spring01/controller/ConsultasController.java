package br.anhembi.spring01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.Consultas;
import br.anhembi.spring01.model.User;
import br.anhembi.spring01.repository.ConsultasRepo;
import br.anhembi.spring01.repository.UserRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    public ResponseEntity<List<Consultas>> findConsultasByUser(@PathVariable long codUser){
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

    @GetMapping("/medConsultas/{codMed}")
    public ResponseEntity<List<Consultas>> findConsultasByMed(@PathVariable long codMed){
        List<Consultas> listaConsultas = (List<Consultas>) repo.findAll();
        
        List<Consultas> consultasFiltradas = new ArrayList<Consultas>();

        for(Consultas c : listaConsultas){
            if(c.getCodMedicoAgendado() == codMed){
                consultasFiltradas.add(c);
            }
        }

        if(!consultasFiltradas.isEmpty()){
            return ResponseEntity.ok(consultasFiltradas);
        }

        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{codConsulta}")
    public ResponseEntity<Consultas> findConsultaById(@PathVariable long codConsulta){
        Consultas consulta = repo.findById(codConsulta).orElse(null);
        
        if(consulta != null){
            return ResponseEntity.ok(consulta);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{statusConsulta}/{codUser}")
    public ResponseEntity<List<Consultas>> findConsultaByStatus(@PathVariable("statusConsulta") String statusConsulta, @PathVariable("codUser") long codUser){
        List<Consultas> listaConsultas = (List<Consultas>)repo.findByStatusConsulta(statusConsulta);
        
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

    @GetMapping("/medico/{codMedico}")
    public ResponseEntity<List<Consultas>> findConsultasByMedico(@PathVariable long codMedico){
        List<Consultas> listaConsultas = (List<Consultas>) repo.findBycodMedicoAgendado(codMedico);
                
        if(!listaConsultas.isEmpty()){
            return ResponseEntity.ok(listaConsultas);
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

    @PutMapping
    public ResponseEntity<Consultas> updateConsulta(@RequestBody Consultas consulta){
        Consultas consultafound = repo.findById(consulta.getCodeConsultas()).orElse(null);
        
        if(consultafound != null ){
            repo.save(consulta);
            return ResponseEntity.ok(consulta);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/remarcar/{codConsulta}")
    public ResponseEntity<Void> updateData(@PathVariable long codConsulta, @RequestParam String newData, @RequestParam String newHour, @RequestParam String newStatus){
        Consultas consulta = repo.findById(codConsulta).orElse(null);

        if(consulta != null){
            consulta.setDtaAgendada(newData);
            consulta.setHorarioAgendado(newHour);
            consulta.setStatusConsulta(newStatus);
            repo.save(consulta);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/status/{codConsulta}")
    public ResponseEntity<Void> updateStatus(@PathVariable long codConsulta, @RequestParam String newStatus){
        Consultas consulta = repo.findById(codConsulta).orElse(null);

        if(consulta != null){
            consulta.setStatusConsulta(newStatus);
            repo.save(consulta);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.notFound().build();
    }
}
