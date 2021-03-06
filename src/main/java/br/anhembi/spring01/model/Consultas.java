package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_consultas")
public class Consultas {
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    @Column(name="codeConsultas")
    private long codeConsultas;

    @Column(name = "dtAgendada", length = 11, nullable = false)
    private String dtaAgendada;
    @Column(name = "horarioAgendado", length = 8, nullable = false)
    private String horarioAgendado;
    @Column(name = "codMedicoAgendado", length = 2, nullable = false)
    private long codMedicoAgendado;
    @Column(name= "idUnidadeAgendado", length = 2, nullable = false)
    private long idUnidadeAgendado;
    @Column(name= "idTipoExame", length = 2, nullable = false)
    private long idTipoExame;
    @Column(name="statusConsulta", length = 50, nullable = false)
    private String statusConsulta;
    
    @Column(name="codeUserConsulta", length = 2, nullable = false)
    private long codeUser;
    
    public long getIdTipoExame() {
        return idTipoExame;
    }
    public void setIdTipoExame(long idTipoExame) {
        this.idTipoExame = idTipoExame;
    }
    public long getIdUnidadeAgendado() {
        return idUnidadeAgendado;
    }
    public void setIdUnidadeAgendado(long idUnidadeAgendado) {
        this.idUnidadeAgendado = idUnidadeAgendado;
    }
    public String getStatusConsulta() {
        return statusConsulta;
    }
    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }
    public long getCodeConsultas() {
        return codeConsultas;
    }
    public void setCodeConsultas(long codeConsultas) {
        this.codeConsultas = codeConsultas;
    }
    public long getCodeUser() {
        return codeUser;
    }
    public void setCodeUser(long codeUser) {
        this.codeUser = codeUser;
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
    public long getCodMedicoAgendado() {
        return codMedicoAgendado;
    }
    public void setCodMedicoAgendado(long codMedicoAgendado) {
        this.codMedicoAgendado = codMedicoAgendado;
    }
}
