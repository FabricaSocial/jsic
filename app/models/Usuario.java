package models;

import models.utils.AppException;
import models.utils.Hash;

import play.db.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
@Table(name="auth_user")
public class Usuario extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Constraints.Required(message="Este campo é obrigatório")
  @Formats.NonEmpty
  @Column(name="password")
  private String senha;

  @Column(name="last_login")
  private LocalDateTime ultimoLogin;

  @Column(name="is_superuser")
  private Boolean superusuario;

  @Constraints.Required(message="Este campo é obrigatório")
  @Formats.NonEmpty
  @Column(name="username",unique=true)
  private String nomeUsuario;

  @Column(name="first_name")
  private String primeiroNome;

  @Column(name="last_name")
  private String ultimoNome;

  @Column(name="email")
  private String email;

  @Column(name="is_staff")
  private Boolean staff;

  @Column(name="is_active")
  private Boolean ativo;

  @Column(name="date_joined")
  private LocalDateTime dataCriacao;

  public Usuario()
  {
    this.senha = "";
    this.ultimoLogin = LocalDateTime.now();
    this.superusuario = false;
    this.nomeUsuario = "";
    this.primeiroNome = "";
    this.ultimoNome = "";
    this.email = "";
    this.staff = false;
    this.ativo = true;
    this.dataCriacao = LocalDateTime.now();
  }

  public Integer getId() { return this.id; }
  public String getSenha() { return this.senha; }
  public void setSenha(String senha) { this.senha = senha; }
  public LocalDateTime getUltimoLogin() { return this.ultimoLogin; }
  public void setUltimoLogin(LocalDateTime ultimoLogin) { this.ultimoLogin = ultimoLogin; }
  public Boolean getSuperusuario() { return this.superusuario; }
  public void setSuperusuario(Boolean superusuario) { this.superusuario = superusuario; }
  public String getNomeUsuario() { return this.nomeUsuario; }
  public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
  public String getPrimeiroNome() { return this.primeiroNome; }
  public void setPrimeiroNome(String primeiroNome) { this.primeiroNome = primeiroNome; }
  public String getUltimoNome() { return this.ultimoNome; }
  public void setUltimoNome(String ultimoNome) { this.ultimoNome = ultimoNome; }
  public String getEmail() { return this.email; }
  public void setEmail(String email) { this.email = email; }
  public Boolean getStaff() { return this.staff; }
  public void setStaff(Boolean staff) { this.staff = staff; }
  public Boolean getAtivo() { return this.ativo; }
  public void setAtivo(Boolean ativo) { this.ativo = ativo; }
  public LocalDateTime getDataCriacao() { return this.dataCriacao; }
  public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

  public static Finder<Integer,Usuario> find =
    new Finder<Integer,Usuario>(Integer.class,Usuario.class);
}
