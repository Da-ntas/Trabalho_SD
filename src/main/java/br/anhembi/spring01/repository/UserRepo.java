package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.User;

//CRUD - create read update delete
public interface UserRepo extends CrudRepository <User, Long>{
    
}
