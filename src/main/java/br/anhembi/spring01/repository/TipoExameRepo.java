package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.TipoExame;

//CRUD - create read update delete
public interface TipoExameRepo extends CrudRepository <TipoExame, Long>{
    
}
