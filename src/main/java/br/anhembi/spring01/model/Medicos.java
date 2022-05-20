package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_medicos")
public class Medicos {
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    private long code;

    @Column(name="nomMedico", length=150, nullable=false)
    private String nomMedico;

    @ManyToOne
    private TipoExame tipoExame;

    public TipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNomMedico() {
        return nomMedico;
    }

    public void setNomMedico(String nomMedico) {
        this.nomMedico = nomMedico;
    }

    
}
