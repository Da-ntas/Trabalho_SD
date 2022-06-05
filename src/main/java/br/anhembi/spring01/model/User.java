package br.anhembi.spring01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // classe será persistida no BD
@Table(name = "tb_users") // nome da tabela, se não colocar vai ser o nome da classe
public class User {
    @Id // indicação q o atributo a baixo é a chave primária no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado pelo bd sequencialmente
    @Column(name="codeUser")
    private long codeUser;

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
    @Column(name="uf", length = 2, nullable = false)
    private long uf;
    @Column(name="cidade", length = 2)
    private long cidade;
    @Column(name="codMed", length = 2, nullable = true)
    private long codMedico;
    @Column(name="role", length = 6, nullable = false)
    private String role;

    public long getCodMedico() {
        return codMedico;
    }
    public void setCodMedico(long codMedico) {
        this.codMedico = codMedico;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public long getUf() {
        return uf;
    }
    public void setUf(long uf) {
        this.uf = uf;
    }
    public long getCidade() {
        return cidade;
    }
    public void setCidade(long cidade) {
        this.cidade = cidade;
    }
    public long getCode() {
        return codeUser;
    }
    public void setCode(long codeUser) {
        this.codeUser = codeUser;
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
    
}
