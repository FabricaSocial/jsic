package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Pais extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  public String nome;

  public Pais()
  {
    this.nome = "";
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getNome()
  {
    return this.nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public String toString()
  {
    return getNome();
  }

  public Model.Finder<Integer,Pais> find =
    new Model.Finder<Integer,Pais>(Integer.class,Pais.class);
}
