package br.anhembi.spring01.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_uf")
public class Uf {
    
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    @Column(name="codeUf")
    private long codeUf;

    @Column(name="nomUF", length = 4, nullable = false)
    private String nomUF;

    public long getcodeUf() {
        return codeUf;
    }

    public void setcodeUf(long codeUf) {
        this.codeUf = codeUf;
    }

    public String getNomUF() {
        return nomUF;
    }

    public void setNomUF(String nomUF) {
        this.nomUF = nomUF;
    }
    


    
}
