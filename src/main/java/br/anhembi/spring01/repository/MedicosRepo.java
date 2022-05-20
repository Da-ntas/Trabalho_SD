package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.Medicos;
//CRUD - create read update delete
public interface MedicosRepo extends CrudRepository <Medicos, Long>{
    
}
