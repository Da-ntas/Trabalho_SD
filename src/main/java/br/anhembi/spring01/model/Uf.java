package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_uf")
public class Uf {
    
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    private long code;

    @Column(name="allUF", length = 4, nullable = false)
    private String nomUF;

    @ManyToOne
    private Cidades cidade;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNomUF() {
        return nomUF;
    }

    public void setNomUF(String nomUF) {
        this.nomUF = nomUF;
    }

    public Cidades getCidade() {
        return cidade;
    }

    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }
    


    
}
