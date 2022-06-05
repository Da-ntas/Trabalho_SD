package br.anhembi.spring01.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.Consultas;

//CRUD - create read update delete
public interface ConsultasRepo extends CrudRepository <Consultas, Long>{
    List<Consultas> findBycodMedicoAgendado (long medico);

    List<Consultas> findByStatusConsulta (String status);
}
