package models.pessoa;

import play.db.ebean.Model.

import javax.persistence.*;

@Entity
public class Nacionalidade extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  public String descricao;

  public Nacionalidade()
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

  public Model.Finder<Integer,Nacionalidade> find =
    new Model.Finder<Integer,Nacionalidade>(Integer.class,Nacionalidade.class);
}
