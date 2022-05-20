package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.Cidades;

//CRUD - create read update delete
public interface CidadesRepo extends CrudRepository <Cidades, Long>{
    
}
