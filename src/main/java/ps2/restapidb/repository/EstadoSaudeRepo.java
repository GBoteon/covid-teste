package ps2.restapidb.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ps2.restapidb.model.EstadoSaude;

public interface EstadoSaudeRepo extends CrudRepository<EstadoSaude, Long>{
    @Query("select e from EstadoSaude e where e.membro.id = ?1")
    Optional<List<EstadoSaude>> findByIdUsuario(long idUsuario);
    
    @Query("select e from EstadoSaude e where e.membro.id = ?1 AND DATE(e.dtCriacao) >= ?2 ORDER BY e.dtCriacao ASC")
    Optional<List<EstadoSaude>> findByIdUsuarioAndInitialDate(long idUsuario, Date initial);
    
    @Query("select e from EstadoSaude e where e.membro.id = ?1 AND (DATE(e.dtCriacao) >= ?2 AND DATE(e.dtCriacao) <= ?3) AND 1=1 ORDER BY e.dtCriacao ASC")
    Optional<List<EstadoSaude>> findByIdUsuarioAndInitiallEndDate(long idUsuario, Date initial, Date end);
    
    @Query("select count(*), CAST(e.dtCriacao AS date) as teste from EstadoSaude e where (DATE(e.dtCriacao) >= ?1 AND DATE(e.dtCriacao) <= ?2) GROUP BY CAST(e.dtCriacao AS date) ORDER BY teste ASC")
    Optional<List<Object>> getQtdRegistrosDiario(Date initial, Date end);
    
    @Query("select count(*), CAST(e.dtCriacao AS date) as teste from EstadoSaude e "
            + " where (DATE(e.dtCriacao) >= ?1 AND DATE(e.dtCriacao) <= ?2) AND e.isBem = ?3 "
            + " GROUP BY CAST(e.dtCriacao AS date) ORDER BY teste ASC")
    Optional<List<Object>> getQtdRegistrosByEstadoSaude(Date initial, Date end, boolean isBem);
    
    @Query("select e.membro.setor, count(*), CAST(e.dtCriacao AS date) as teste from EstadoSaude e "
            + " where (DATE(e.dtCriacao) >= ?1 AND DATE(e.dtCriacao) <= ?2) "
            + " GROUP BY e.membro.setor, CAST(e.dtCriacao AS date) ORDER BY teste ASC")
    Optional<List<Object>> getQtdRegistrosBySetor(Date initial, Date end);
    
    @Query("select e.membro.setor, count(*), CAST(e.dtCriacao AS date) as teste from EstadoSaude e "
            + " where (DATE(e.dtCriacao) >= ?1 AND DATE(e.dtCriacao) <= ?2) AND e.isBem = ?3 "
            + " GROUP BY e.membro.setor, CAST(e.dtCriacao AS date) ORDER BY teste ASC")
    Optional<List<Object>> getQtdRegistrosBySetor(Date initial, Date end, boolean isBem);
}
