package ps2.restapidb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Membro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected long idRole;
    protected String nome;
    protected int username;
    protected String senha;
    protected String setor;
    protected String data_nascimento;
    protected String cidade;
    protected String estado;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    protected Role role;

    public Membro(String nome, String setor, String senha, String data_nascimento, String cidade, String estado, long idRole){
        this.nome = nome;
        this.setor = setor;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.idRole = idRole;
    }

    public Membro() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //    @Id
//    @GeneratedValue
//    protected long id;
//    protected int matricula;
//    protected String nome;
//    protected String setor;
//    protected String senha;
//    protected String dataNasc;
//    protected String cidade;
//    protected String estado;
//    protected Long id_tipo_usuario;
//
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    protected TipoUsuario tipoUsuario;
//
//    public Usuario() {
//
//    }
//
//    public Usuario(long id, String nome, String setor, String senha, String dataNasc, String cidade, String estado, Long id_tipo_usuario, int matricula) {
//        this.id = id;
//        this.nome = nome;
//        this.setor = setor;
//        this.senha = senha;
//        this.dataNasc = dataNasc;
//        this.cidade = cidade;
//        this.estado = estado;
//        this.id_tipo_usuario = id_tipo_usuario;
//        this.matricula = matricula;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public TipoUsuario getTipoUsuario() {
//        return tipoUsuario;
//    }
//
//    public void setTipoUsuario(TipoUsuario tipo) {
//        this.tipoUsuario = tipo;
//    }
//
//    public Long getIdTipoUsuario() {
//        return id_tipo_usuario;
//    }
//
//    public void setIdTipoUsuario(Long id) {
//        this.id_tipo_usuario = id;
//    }
//
//    public String getSetor() {
//        return setor;
//    }
//
//    public void setSetor(String setor) {
//        this.setor = setor;
//    }
//
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
//
//    public String getDataNasc() {
//        return dataNasc;
//    }
//
//    public void setDataNasc(String dataNasc) {
//        this.dataNasc = dataNasc;
//    }
//
//    public String getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(String cidade) {
//        this.cidade = cidade;
//    }
//
//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//
//    public int getMatricula() {
//        return matricula;
//    }
//
//    public void setMatricula(int matricula) {
//        this.matricula = matricula;
//    }

}
