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
    private long code;

    @Column(name="tipoExame", length=200, nullable = false)
    private String exameTipo;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getTipoExame() {
        return exameTipo;
    }

    public void setTipoExame(String exameTipo) {
        this.exameTipo = exameTipo;
    }

    
}
