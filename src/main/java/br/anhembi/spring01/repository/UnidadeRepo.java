package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.Unidades;

//CRUD - create read update delete
public interface UnidadeRepo extends CrudRepository <Unidades, Long>{
    
}
