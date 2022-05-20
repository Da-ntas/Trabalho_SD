package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_cidades")
public class Cidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;

    @Column(name="cidades", length = 150, nullable = false)
    private String nomCidades;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNomCidades() {
        return nomCidades;
    }

    public void setNomCidades(String nomCidades) {
        this.nomCidades = nomCidades;
    }
}
