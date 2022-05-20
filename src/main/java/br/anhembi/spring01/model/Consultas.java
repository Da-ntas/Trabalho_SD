package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_consultas")
public class Consultas {
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    private long code;

    @ManyToOne
    private User user;

    @Column(name = "dtAgendada", length = 11, nullable = false)
    private String dtaAgendada;
    @Column(name = "horarioAgendado", length = 8, nullable = false)
    private String horarioAgendado;
    @Column(name = "nomMedicoAgendado", length = 50, nullable = false)
    private String nomMedicoAgendado;
    @Column(name = "enderecoAgendado", length = 150, nullable = false)
    private String enderecoAgendado;
    @Column(name = "valorConsulta", length = 150, nullable = false)
    private double valorConsulta;
    @Column(name = "modoPagamento", length = 150, nullable = false)
    private String modoPagamento;
    @Column(name = "reembolsoConvenio", length = 150, nullable = false)
    private boolean reembolsoConvenio;
    

    public long getCode() {
        return code;
    }
    public void setCode(long code) {
        this.code = code;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getDtaAgendada() {
        return dtaAgendada;
    }
    public void setDtaAgendada(String dtaAgendada) {
        this.dtaAgendada = dtaAgendada;
    }
    public String getHorarioAgendado() {
        return horarioAgendado;
    }
    public void setHorarioAgendado(String horarioAgendado) {
        this.horarioAgendado = horarioAgendado;
    }
    public String getNomMedicoAgendado() {
        return nomMedicoAgendado;
    }
    public void setNomMedicoAgendado(String nomMedicoAgendado) {
        this.nomMedicoAgendado = nomMedicoAgendado;
    }
    public String getEnderecoAgendado() {
        return enderecoAgendado;
    }
    public void setEnderecoAgendado(String enderecoAgendado) {
        this.enderecoAgendado = enderecoAgendado;
    }
    public double getValorConsulta() {
        return valorConsulta;
    }
    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
    public String getModoPagamento() {
        return modoPagamento;
    }
    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }
    public boolean isReembolsoConvenio() {
        return reembolsoConvenio;
    }
    public void setReembolsoConvenio(boolean reembolsoConvenio) {
        this.reembolsoConvenio = reembolsoConvenio;
    }
}
