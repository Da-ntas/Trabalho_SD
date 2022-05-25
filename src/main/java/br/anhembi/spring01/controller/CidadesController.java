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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.Cidades;
import br.anhembi.spring01.model.Uf;
import br.anhembi.spring01.repository.CidadesRepo;
import br.anhembi.spring01.repository.UfRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cidades")
public class CidadesController {
    
    @Autowired //injeção de independencia
    private CidadesRepo repo; 

    @Autowired
    private UfRepo ufRepo;

    //get all
    @GetMapping
    public ResponseEntity <List<Cidades>> findAll(){
        List<Cidades> listcidades = (List<Cidades>) repo.findAll();
        return ResponseEntity.ok(listcidades);
    }

    @GetMapping("/cidadeporuf/{codeUF}")
    public ResponseEntity <List<Cidades>> findCidadeByUF(@PathVariable long codeUF){
        List<Cidades> listCidades = (List<Cidades>)repo.findAll();
        
        List<Cidades> cidadesFiltradas = new ArrayList<Cidades>();

        for(Cidades c : listCidades){
            if(c.getUfId() == codeUF){
                cidadesFiltradas.add(c);
            }
        }
        
        if(!cidadesFiltradas.isEmpty()){
            return ResponseEntity.ok(cidadesFiltradas);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{codeUf}")
    public ResponseEntity<Cidades> insertCidadesWithUF(@PathVariable long codeUf, @RequestBody Cidades cidade){

        Uf uf = ufRepo.findById(codeUf).orElse(null);
        
        if(uf != null){

            Cidades newCidade = repo.save(cidade);
            newCidade.setUfId(codeUf);
            newCidade = repo.save(newCidade);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCidade);

        }

        return ResponseEntity.notFound().build();

    }
    
}
