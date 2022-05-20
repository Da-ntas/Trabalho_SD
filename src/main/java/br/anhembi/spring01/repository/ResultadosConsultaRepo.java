package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.ResultadosConsulta;

//CRUD - create read update delete
public interface ResultadosConsultaRepo extends CrudRepository <ResultadosConsulta, Long>{
    
}
