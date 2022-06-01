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

import br.anhembi.spring01.model.TipoExame;
import br.anhembi.spring01.model.Unidades;
import br.anhembi.spring01.repository.TipoExameRepo;
import br.anhembi.spring01.repository.UnidadeRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tipoexames")
public class TipoExameController {
    @Autowired //injeção de independencia
    private TipoExameRepo repo; 

    @Autowired 
    private UnidadeRepo unidadeRepo;

    //get all
    @GetMapping
    public ResponseEntity <List<TipoExame>> findAll(){
        List<TipoExame> listTipoExame = (List<TipoExame>) repo.findAll();
        return ResponseEntity.ok(listTipoExame);
    }

    @GetMapping("/unidade/{codeUnidade}")
    public ResponseEntity <List<TipoExame>> findTipoExamesByCidades(@PathVariable long codeUnidade){
        List<TipoExame> listTipoExames = (List<TipoExame>) repo.findAll();

        List<TipoExame> tipoExamesFiltrados = new ArrayList<TipoExame>();

        for(TipoExame t : listTipoExames){
            if(t.getCodeUnidade() == codeUnidade){
                tipoExamesFiltrados.add(t);
            }
        }
        
        if(!tipoExamesFiltrados.isEmpty()){
            return ResponseEntity.ok(tipoExamesFiltrados);
        }

        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/{codeUnidade}")
    public ResponseEntity <TipoExame> insertTipoExameWithCidades(@PathVariable long codeUnidade, @RequestBody TipoExame tipoExame){
        Unidades unidade = unidadeRepo.findById(codeUnidade).orElse(null);

        if(unidade != null){
            TipoExame newtipoExame = repo.save(tipoExame);
            newtipoExame.setCodeUnidade(codeUnidade);
            newtipoExame = repo.save(newtipoExame);

            return ResponseEntity.status(HttpStatus.CREATED).body(newtipoExame);
        }

        return ResponseEntity.notFound().build();
    }

}
