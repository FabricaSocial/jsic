package models.pessoa.funcionario;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

import models.Usuario;

@Entity
@Table(name="FuncionarioAudit")
public class FuncionarioAudit extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="timestamp")
  private Date timestamp;

  @ManyToOne
  @JoinColumn(name="auth_user_id", referencedColumnName="id")
  private Usuario usuario;

  @ManyToOne
  @JoinColumn(name="tipo_audit_id", referencedColumnName="id")
  private TipoAudit tipoAudit;

  @ManyToOne
  @JoinColumn(name="cargo_id", referencedColumnName="id")
  private Cargo cargo;

  public FuncionarioAudit()
  {
    this.timestamp = new Date();
    this.usuario = new Usuario();
    this.tipoAudit = new TipoAudit();
    this.cargo = new Cargo();
  }

  public Integer getId() { return this.id; }
  public Date getTimestamp() { return this.timestamp; }
  public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
  public Usuario getUsuario() { return this.usuario; }
  public void setUsuario(Usuario usuario) { this.usuario = usuario; }
  public TipoAudit getTipoAudit() { return this.tipoAudit; }
  public void setTipoAudit(TipoAudit tipoAudit) { this.tipoAudit = tipoAudit; }
  public Cargo getCargo() { return this.cargo; }
  public void setCargo(Cargo cargo) { this.cargo = cargo; }

  public String toString()
  {
    return getUsuario().toString() + " - " + getTipoAudit().toString();
  }

  public static Finder<Integer,FuncionarioAudit> find =
    new Finder<Integer,FuncionarioAudit>(Integer.class,FuncionarioAudit.class);
}
