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
  @Column(name="nome_usuario",unique=true)
  private String nomeUsuario;

  @Constraints.Required(message="Este campo é obrigatório")
  @Formats.NonEmpty
  @Column(name="hash_senha")
  private String hashSenha;

  @Column(name="data_criacao")
  private Date dataCriacao;


  public Integer getId() { return this.id; }
  public String getNomeUsuario() { return this.nomeUsuario; }
  public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
  public String getHashSenha() { return this.hashSenha; }
  public void setHashSenha(String hashSenha) { this.hashSenha = hashSenha; }
  public Date getDataCriacao() { return this.dataCriacao; }
  public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

  public static Finder<Integer,Usuario> find =
    new Finder<Integer,Usuario>(Integer.class,Usuario.class);

  public static Usuario procuraPorNome(String nomeUsuario)
  {
    return find.where().eq("nome_usuario", nomeUsuario).findUnique();
  }

  public static Usuario autenticar(String nomeUsuario, String senhaLimpa)
    throws AppException
  {
    Usuario usuario = find.where().eq("nome_usuario", nomeUsuario).findUnique();
    if(usuario != null)
    {
      if(Hash.checaSenha(senhaLimpa, usuario.hashSenha))
      {
        return usuario;
      }
    }

    return null;
  }

  public void mudaSenha(String senha)
    throws AppException
  {
    this.hashSenha = Hash.criarSenha(senha);
    this.save();
  }
}
