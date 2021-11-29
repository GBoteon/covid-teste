package ps2.restapidb.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "estado_saude")
public class EstadoSaude {

    @Id
    @GeneratedValue
    protected long id;

    protected boolean isBem = true;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    protected Membro membro;

    @Transient
    protected long idUsuario;

    @Column(name = "dtCriacao", insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dtCriacao;
    
    @ManyToMany
    @JoinTable(
            name="estado_saude_sintomas", 
            joinColumns = {@JoinColumn(name="estado_saude_id")}, 
            inverseJoinColumns = {@JoinColumn(name="sintoma_id")})
    public List <Sintoma> sintomas;

    public EstadoSaude() {

    }
    
    public EstadoSaude(long id, boolean isBem, long idUsuario) {
        this.id = id;
        this.isBem = isBem;
        this.idUsuario = idUsuario;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public long getId() {
        return id;
    }

    public boolean isIsBem() {
        return isBem;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsBem(boolean isBem) {
        this.isBem = isBem;
    }    

    public Membro getUsuario() {
        return membro;
    }

    public void setUsuario(Membro membro) {
        this.membro = membro;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List getSintomas() {
        return sintomas;
    }

    public void setSintomas(List sintomas) {
        this.sintomas = sintomas;
    }
    
    
}
