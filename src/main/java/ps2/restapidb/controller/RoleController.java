package ps2.restapidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ps2.restapidb.model.Role;
import ps2.restapidb.repository.RoleRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/api/tipo-usuario")
    public List<Role> getTipoUsuarios(){
        List<Role> role = new ArrayList<>();
        roleRepo.findAll().forEach(role::add);
        return role;
    }

    @GetMapping("/api/tipo-usuario/{id}")
    public Role getTipoUsuario(@PathVariable long id) {
        Optional<Role> retorno = roleRepo.findById(id);
        Role role = null;
        if(retorno.isPresent()) {
            role = retorno.get();
        }
        return role;
    }

    @PostMapping("/api/tipo-usuario")
    public Role createTipoUsuario(@RequestBody Role role) {
    	roleRepo.save(role);
        return role;
    }

    @PutMapping("/api/tipo-usuario/{id}")
    public Role updateTipoUsuario(@RequestBody Role a, @PathVariable long id) {
        Role role = null;
    	role = this.getTipoUsuario(id);
        if(role != null) {
            roleRepo.save(a);
            role = a;
        }
        return a;
    }

    @DeleteMapping(value = "/api/tipo-usuario/{id}", produces = "application/json")
    public String deleteTipoUsuario(@PathVariable long id) {
        Role role = this.getTipoUsuario(id);
        boolean result = false;
        if(role != null) {
        	roleRepo.delete(role);
            result = true;
        }
        return "{ \"sucess\" : " + (result ? "true" : "false" ) + " }";
    }
	
}
