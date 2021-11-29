package ps2.restapidb.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Funcionario extends Membro {

    private int num_funcional;

    public Funcionario(String nome, String senha, String data_nascimento, String cidade, String estado, int num_funcional, int idRole){
        this.num_funcional = num_funcional;
        this.nome = nome;
        this.username = num_funcional;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.idRole = idRole;
    }

    public Funcionario() {
        super();
    }

    public int getNum_funcional() {
        return num_funcional;
    }

    public void setNum_funcional(int num_funcional) {
        this.num_funcional = num_funcional;
    }

}