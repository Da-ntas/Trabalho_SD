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

import br.anhembi.spring01.model.Cidades;
import br.anhembi.spring01.model.Unidades;
import br.anhembi.spring01.repository.CidadesRepo;
import br.anhembi.spring01.repository.UnidadeRepo;

@RestController
@RequestMapping("/unidades")
public class UnidadesController {
    
    @Autowired //injeção de independencia
    private UnidadeRepo repo; 

    @Autowired 
    private CidadesRepo cidadesRepo;

    //get all
    @GetMapping
    public ResponseEntity <List<Unidades>> findAll(){
        List<Unidades> listuser = (List<Unidades>) repo.findAll();
        return ResponseEntity.ok(listuser);
    }

    @GetMapping("/cidades/{codeCidades}")
    public ResponseEntity <List<Unidades>> findUnidadesByCidades(@PathVariable long codeCidades){
        List<Unidades> listUnidades = (List<Unidades>)repo.findAll();
        
        List<Unidades> unidadesFiltradas = new ArrayList<Unidades>();

        for(Unidades u : listUnidades){
            if(u.getCodCidade() == codeCidades){
                unidadesFiltradas.add(u);
            }
        }
        
        if(!unidadesFiltradas.isEmpty()){
            return ResponseEntity.ok(unidadesFiltradas);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{codeCidades}")
    public ResponseEntity<Unidades> insertUnidadesWithCidades(@PathVariable long codeCidades, @RequestBody Unidades unidade){
        Cidades cidade = cidadesRepo.findById(codeCidades).orElse(null);
        
        if(cidade != null){

            Unidades newUnidade = repo.save(unidade);
            newUnidade.setCodCidade(codeCidades);
            newUnidade = repo.save(newUnidade);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUnidade);

        }

        return ResponseEntity.notFound().build();
    }


}

