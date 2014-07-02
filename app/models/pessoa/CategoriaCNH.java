package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="CategoriaCNH")
public class CategoriaCNH extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="categoria")
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

  public static Finder<Integer,CategoriaCNH> find =
    new Finder<Integer,CategoriaCNH>(Integer.class,CategoriaCNH.class);
}
