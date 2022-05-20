package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_unidades")
public class Unidades {
    
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    private long code;

    @Column(name="nomUnidade", length = 200, nullable = false)
    private String nomUnidade;

    // @ManyToMany
    // private TipoExame tipoExame;
    // @ManyToMany
    // private Cidades cidade;

    // @ManyToMany
    // private Medicos medicos;

    // public Medicos getMedicos() {
    //     return medicos;
    // }

    // public void setMedicos(Medicos medicos) {
    //     this.medicos = medicos;
    // }

    // public TipoExame getTipoExame() {
    //     return tipoExame;
    // }

    // public void setTipoExame(TipoExame tipoExame) {
    //     this.tipoExame = tipoExame;
    // }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNomUnidade() {
        return nomUnidade;
    }

    public void setNomUnidade(String nomUnidade) {
        this.nomUnidade = nomUnidade;
    }

    // public Cidades getCidade() {
    //     return cidade;
    // }

    // public void setCidade(Cidades cidade) {
    //     this.cidade = cidade;
    // }
}
