package ps2.restapidb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="tipo_usuarios")
public class TipoUsuario {
    
    @Id @GeneratedValue
    protected long id;
    protected String nome;
    
    public TipoUsuario() {

    }

    public TipoUsuario(long id, String nome) {
            this.id = id;
            this.nome = nome;
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
}
