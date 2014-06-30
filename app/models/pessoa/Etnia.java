package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Etnia extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  public String descricao;

  public Etnia()
  {
    this.descricao = "";
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getDescricao()
  {
    return this.descricao;
  }

  public void setDescricao(String descricao)
  {
    this.descricao = descricao;
  }

  public String toString()
  {
    return getDescricao();
  }

  public Model.Finder<Integer,Etnia> find =
    new Model.Finder<Integer,Etnia>(Integer.class,Etnia.class);
}
