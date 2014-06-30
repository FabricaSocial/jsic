package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class CategoriaCNH extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String categoria;

  public CategoriaCNH()
  {
    this.categoria = "";
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getCategoria()
  {
    return this.categoria;
  }

  public void setCategoria(String categoria)
  {
    this.categoria = categoria;
  }

  public String toString()
  {
    return getCategoria();
  }

  public Model.Finder<Integer,CategoriaCNH> find =
    new Model.Finder<Integer,CategoriaCNH>(Integer.class,CategoriaCNH.class);
}
