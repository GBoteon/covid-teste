package ps2.restapidb.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity

@Table(name="sintoma")
public class Sintoma {

    @Id @GeneratedValue
    protected long id;
    protected String nome;

    @ManyToMany
    @JoinTable(
        name = "estado_saude_sintomas",
        joinColumns = @JoinColumn(name = "sintoma_id"),
        inverseJoinColumns = @JoinColumn(name = "estado_saude_id")
    )
    protected Set<EstadoSaude> estadosSaude;

    public Sintoma() {

    }

    public Sintoma(long id, String nome) {
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
