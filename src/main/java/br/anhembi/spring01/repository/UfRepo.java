package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.Uf;

//CRUD - create read update delete
public interface UfRepo extends CrudRepository <Uf, Long>{
    
}
