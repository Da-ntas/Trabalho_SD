package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_unidades")
public class Unidades {
    
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    @Column(name="codeUnidades")
    private long codeUnidades;

    @Column(name="nomUnidade", length = 200, nullable = false)
    private String nomUnidade;

    @Column(name="codCidade", length = 2)
    private long codCidade;
    
    public long getcodeUnidades() {
        return codeUnidades;
    }

    public void setCodeUnidades(long codeUnidades) {
        this.codeUnidades = codeUnidades;
    }

    public long getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(long codCidade) {
        this.codCidade = codCidade;
    }

    public String getNomUnidade() {
        return nomUnidade;
    }

    public void setNomUnidade(String nomUnidade) {
        this.nomUnidade = nomUnidade;
    }

}
