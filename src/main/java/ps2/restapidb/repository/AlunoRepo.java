package ps2.restapidb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ps2.restapidb.model.Aluno;

import java.util.Optional;

public interface AlunoRepo extends CrudRepository<Aluno, Long>{

    @Query("select u from Aluno u where u.username = ?1 AND u.senha = ?2")
    Optional<Aluno> logar(int username, String senha);

    @Query("select u from Aluno u where u.username = ?1")
    Optional<Aluno> findByUsername(int username);

}
