package ps2.restapidb.model;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Aluno extends Membro{

    protected int num_matricula;

    public Aluno(String nome, String senha, String data_nascimento, String cidade, String estado, int num_matricula, int idRole){
        this.num_matricula = num_matricula;
        this.nome = nome;
        this.username = num_matricula;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.idRole = idRole;
    }

    public Aluno() {

    }

    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }
}
