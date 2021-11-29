package ps2.restapidb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ps2.restapidb.model.Funcionario;

import java.util.Optional;

public interface FuncionarioRepo extends CrudRepository<Funcionario, Long>{

    @Query("select u from Funcionario u where u.username = ?1 AND u.senha = ?2")
    Optional<Funcionario> logar(int username, String senha);

    @Query("select u from Funcionario u where u.username = ?1")
    Optional<Funcionario> findByUsername(int username);
}