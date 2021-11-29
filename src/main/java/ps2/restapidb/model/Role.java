package ps2.restapidb.model;

import javax.persistence.*;

@Entity

@Table(name="role")
public class Role {

    @Id
    @GeneratedValue
    protected Long idRole;
    protected String name;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    
//    @Id @GeneratedValue
//    protected long id;
//    protected String nome;
//
//    public Role() {
//
//    }
//
//    public Role(long id, String nome) {
//            this.id = id;
//            this.nome = nome;
//    }
//
//    public long getId() {
//            return id;
//    }
//
//    public void setId(long id) {
//            this.id = id;
//    }
//
//    public String getNome() {
//            return nome;
//    }
//
//    public void setNome(String nome) {
//            this.nome = nome;
//    }
}
