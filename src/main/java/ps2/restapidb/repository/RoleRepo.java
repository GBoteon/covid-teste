package ps2.restapidb.repository;

import org.springframework.data.repository.CrudRepository;
import ps2.restapidb.model.Role;

public interface RoleRepo extends CrudRepository<Role, Long>{
    
}
