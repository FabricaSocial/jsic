package models.pessoa.funcionario;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import models.pessoa.Pessoa;
import models.Usuario;

@Entity
@Table(name="Funcionario")
public class Funcionario extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="matricula")
  private Integer matricula;

  @Column(name="status")
  private Boolean status;

  @OneToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  @ManyToOne
  @JoinColumn(name="cargo_id", referencedColumnName="id")
  private Cargo cargo;

  @ManyToOne
  @JoinColumn(name="departamento_id", referencedColumnName="id")
  private Departamento departamento;

  @OneToOne
  @JoinColumn(name="usuario_id", referencedColumnName="id")
  private Usuario usuario;

  public Funcionario()
  {
    this.matricula = 0;
    this.status = false;
    this.pessoa = new Pessoa();
    this.cargo = new Cargo();
    this.departamento = new Departamento();
    this.usuario = new Usuario();
  }

  public Integer getId() { return this.id; }
  public Integer getMatricula() { return this.matricula; }
  public void setMatricula(Integer matricula) { this.matricula = matricula; }
  public Boolean getStatus() { return this.status; }
  public void setStatus(Boolean tatus) { this.status = status; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
  public Cargo getCargo() { return this.cargo; }
  public void setCargo(Cargo cargo) { this.cargo = cargo; }
  public Departamento getDepartamento() { return this.departamento; }
  public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
  public Usuario getUsuario() { return this.usuario; }
  public void setUsuario(Usuario usuario) { this.usuario = usuario; }

  public String toString()
  {
    return getMatricula().toString() + " - " + getCargo().toString() +
      " - " + getPessoa().toString();
  }

  public static Finder<Integer,Funcionario> find =
    new Finder<Integer,Funcionario>(Integer.class,Funcionario.class);
}
