package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_resultadoConsulta")
public class ResultadosConsulta {

    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    private long code;

    @OneToOne
    private Consultas consulta;
    @Column(name="descricao", length = 500, nullable = false)
    private String descricao;
    @Column(name="solicitacoes", length = 200, nullable = false)
    private String solicitacoes;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Consultas getConsulta() {
        return consulta;
    }

    public void setConsulta(Consultas consulta) {
        this.consulta = consulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(String solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

}
