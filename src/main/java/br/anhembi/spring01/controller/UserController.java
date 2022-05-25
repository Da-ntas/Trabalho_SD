package br.anhembi.spring01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.User;
import br.anhembi.spring01.repository.UserRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController //indica que esse é um controle rest
@RequestMapping("/user") //indica o caminho da request para acessara esse controller
public class UserController {
    
    @Autowired //injeção de independencia
    private UserRepo repo;

    //get all
    @GetMapping
    public ResponseEntity <List<User>> findAll(){
        List<User> listuser = (List<User>) repo.findAll();
        return ResponseEntity.ok(listuser);
    }

    //get id
    @GetMapping("/{id}")
    public ResponseEntity <User> findUser(@PathVariable long id){
        User user = repo.findById(id).orElse(null);
        
        if(user != null ){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/login")
    public ResponseEntity <User> findUserByEmail(@RequestParam String email){
        User user = repo.findByEmail(email);
        
        if(user != null ){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user){

        User newUser = repo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User userfound = repo.findById(user.getCode()).orElse(null);
        
        if(userfound != null ){
            repo.save(user);
            return ResponseEntity.ok(userfound);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        User user = repo.findById(id).orElse(null);

        if(user != null){
            repo.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build();
    }
}
