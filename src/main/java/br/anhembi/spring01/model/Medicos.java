package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_medicos")
public class Medicos {
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    @Column(name="codeMedicos")
    private long codeMedicos;

    @Column(name="nomMedico", length=150, nullable=false)
    private String nomMedico;

    @Column(name="codTipoExame", length = 2)
    private long codTipoExame;

    public long getCodeMedicos() {
        return codeMedicos;
    }

    public void setCodeMedicos(long codeMedicos) {
        this.codeMedicos = codeMedicos;
    }

    public long getCodTipoExame() {
        return codTipoExame;
    }

    public void setCodTipoExame(long codTipoExame) {
        this.codTipoExame = codTipoExame;
    }

    public String getNomMedico() {
        return nomMedico;
    }

    public void setNomMedico(String nomMedico) {
        this.nomMedico = nomMedico;
    }

    
}
