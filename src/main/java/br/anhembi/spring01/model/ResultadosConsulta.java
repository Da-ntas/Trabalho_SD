package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_resultadoConsulta")
public class ResultadosConsulta {

    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    @Column(name="codeResultadoConsulta")
    private long codeResultadoConsulta;

    @Column(name="descricao", length = 500, nullable = false)
    private String descricao;
    @Column(name="solicitacoes", length = 500, nullable = false)
    private String solicitacoes;
    @Column(name="codeConsultas", length = 2)
    private long codeConsultas;

    public long getCodeResultadoConsulta() {
        return codeResultadoConsulta;
    }

    public void setCodeResultadoConsulta(long codeResultadoConsulta) {
        this.codeResultadoConsulta = codeResultadoConsulta;
    }

    public long getCodeConsultas() {
        return codeConsultas;
    }

    public void setCodeConsultas(long codeConsultas) {
        this.codeConsultas = codeConsultas;
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
