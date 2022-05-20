package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // classe será persistida no BD
@Table(name = "tb_user") // nome da tabela, se não colocar vai ser o nome da classe
public class User {
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    private long code;

    @Column(name = "nameUser", length = 150, nullable = false)
    private String nome;
    @Column(name = "emailUser", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name="passwordUser", length = 50, nullable = false)
    private String password;
    @Column(name="dataNasc", length = 10, nullable = false)
    private String dataNasc;
    @Column(name="cpf", length = 11, nullable = false, unique=true)
    private long cpf;
    @Column(name="uf", length = 4, nullable = false)
    private String uf;
    @Column(name="cidade", length = 100, nullable = false)
    private String cidade;
    @Column(name="convenio", length = 50, nullable = false)
    private boolean convenio;
    @Column(name="nomConvenio", length = 100, nullable = true)
    private String nomConvenio;
    @Column(name="codConvenio", length = 50, nullable = true)
    private long codConvenio;

    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public long getCode() {
        return code;
    }
    public void setCode(long code) {
        this.code = code;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public boolean getConvenio() {
        return convenio;
    }
    public void setConvenio(boolean convenio) {
        this.convenio = convenio;
    }
    public String getNomConvenio() {
        return nomConvenio;
    }
    public void setNomConvenio(String nomConvenio) {
        this.nomConvenio = nomConvenio;
    }
    public long getCodConvenio() {
        return codConvenio;
    }
    public void setCodConvenio(long codConvenio) {
        this.codConvenio = codConvenio;
    }
    
}
