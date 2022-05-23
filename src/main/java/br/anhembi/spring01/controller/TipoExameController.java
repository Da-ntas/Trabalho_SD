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
import br.anhembi.spring01.model.TipoExame;
import br.anhembi.spring01.repository.CidadesRepo;
import br.anhembi.spring01.repository.TipoExameRepo;

@RestController
@RequestMapping("/tipoexames")
public class TipoExameController {
    @Autowired //injeção de independencia
    private TipoExameRepo repo; 

    @Autowired 
    private CidadesRepo cidadeRepo;

    //get all
    @GetMapping
    public ResponseEntity <List<TipoExame>> findAll(){
        List<TipoExame> listTipoExame = (List<TipoExame>) repo.findAll();
        return ResponseEntity.ok(listTipoExame);
    }

    @GetMapping("/{codeCidade}")
    public ResponseEntity <List<TipoExame>> findTipoExamesByCidades(@PathVariable long codeCidade){
        List<TipoExame> listTipoExames = (List<TipoExame>) repo.findAll();

        List<TipoExame> tipoExamesFiltrados = new ArrayList<TipoExame>();

        for(TipoExame t : listTipoExames){
            if(t.getCodeCidade() == codeCidade){
                tipoExamesFiltrados.add(t);
            }
        }
        
        if(!tipoExamesFiltrados.isEmpty()){
            return ResponseEntity.ok(tipoExamesFiltrados);
        }

        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/{codeCidade}")
    public ResponseEntity <TipoExame> insertTipoExameWithCidades(@PathVariable long codeCidade, @RequestBody TipoExame tipoExame){
        Cidades cidade = cidadeRepo.findById(codeCidade).orElse(null);

        if(cidade != null){
            TipoExame newtipoExame = repo.save(tipoExame);
            newtipoExame.setCodeCidade(codeCidade);
            newtipoExame = repo.save(newtipoExame);

            return ResponseEntity.status(HttpStatus.CREATED).body(newtipoExame);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoExame> insertTiposExames(@RequestBody TipoExame tipoexame){

        TipoExame newTipoExame = repo.save(tipoexame);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTipoExame);
    }

}
