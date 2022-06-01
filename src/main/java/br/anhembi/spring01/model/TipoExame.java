package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipoExame")
public class TipoExame {
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    @Column(name="codeExame")
    private long codeExame;

    @Column(name="tipoExame", length=200, nullable = false)
    private String exameTipo;

    @Column(name="codeUnidade", length = 2, unique = true)
    private long codeUnidade;
    

    public long getCodeExame() {
        return codeExame;
    }

    public void setCodeExame(long codeExame) {
        this.codeExame = codeExame;
    }

    public String getExameTipo() {
        return exameTipo;
    }

    public void setExameTipo(String exameTipo) {
        this.exameTipo = exameTipo;
    }

    public long getCodeUnidade() {
        return codeUnidade;
    }

    public void setCodeUnidade(long codeUnidade) {
        this.codeUnidade = codeUnidade;
    }
    
}
