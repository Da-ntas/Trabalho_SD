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
    @Column(name="codeCidades")
    private long codeCidades;

    @Column(name="cidades", length = 150, nullable = false)
    private String nomCidades;

    @Column(name="ufId", length= 2, nullable = true)
    private long ufId;

    public long getUfId() {
        return ufId;
    }

    public void setUfId(long ufId) {
        this.ufId = ufId;
    }

    public long getCodeCidades() {
        return codeCidades;
    }

    public void setCodeCidades(long codeCidades) {
        this.codeCidades = codeCidades;
    }

    public String getNomCidades() {
        return nomCidades;
    }

    public void setNomCidades(String nomCidades) {
        this.nomCidades = nomCidades;
    }
}
