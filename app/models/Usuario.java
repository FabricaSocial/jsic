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

import java.util.Date;

@Entity
@Table(name="Usuario")
public class Usuario extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Constraints.Required(message="Este campo é obrigatório")
  @Formats.NonEmpty
  @Column(name="senha")
  private String senha;

  @Column(name="ultimo_login")
  private Date ultimoLogin;

  @Column(name="superusuario")
  private Boolean superusuario;

  @Constraints.Required(message="Este campo é obrigatório")
  @Formats.NonEmpty
  @Column(name="nome_usuario",unique=true)
  private String nomeUsuario;

  @Column(name="primeiro_nome")
  private String primeiroNome;

  @Column(name="ultimo_nome")
  private String ultimoNome;

  @Column(name="email")
  private String email;

  @Column(name="ativo")
  private Boolean ativo;

  @Column(name="data_criacao")
  private Date dataCriacao;

  public Usuario()
  {
    this.senha = "";
    this.ultimoLogin = new Date();
    this.superusuario = false;
    this.nomeUsuario = "";
    this.primeiroNome = "";
    this.ultimoNome = "";
    this.email = "";
    this.ativo = true;
    this.dataCriacao = new Date();
  }

  public Integer getId() { return this.id; }
  public String getSenha() { return this.senha; }
  public void setSenha(String senha) { this.senha = senha; }
  public Date getUltimoLogin() { return this.ultimoLogin; }
  public void setUltimoLogin(Date ultimoLogin) { this.ultimoLogin = ultimoLogin; }
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
  public Boolean getAtivo() { return this.ativo; }
  public void setAtivo(Boolean ativo) { this.ativo = ativo; }
  public Date getDataCriacao() { return this.dataCriacao; }
  public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

  public String toString()
  {
    return getNomeUsuario();
  }

  public static Finder<Integer,Usuario> find =
    new Finder<Integer,Usuario>(Integer.class,Usuario.class);
}
