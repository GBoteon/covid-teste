package ps2.restapidb.repository;

import org.springframework.data.repository.CrudRepository;
import ps2.restapidb.model.TipoUsuario;

public interface TipoUsuarioRepo extends CrudRepository<TipoUsuario, Long>{
    
}
