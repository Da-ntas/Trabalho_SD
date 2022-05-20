package br.anhembi.spring01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica que esse é um controle rest
@RequestMapping("/hello") //indica o caminho da request para acessara esse controller
public class zHello {
    
    
    @GetMapping // recurso GET
    public ResponseEntity<String> olaMundo(){
        return ResponseEntity.ok("Hi"); //pl = 200
    }

    @GetMapping("/noite")
    public ResponseEntity<String> tchauMundo(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("noite");
    }
    
    @GetMapping("/pessoa/{nome}")
    public ResponseEntity<String> id(@PathVariable String nome){
        if(nome.equals("sla")){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("noite " + nome);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nome não existe aqui");
    }
}
