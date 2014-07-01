package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Etnia")
public class Etnia extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  @OneToMany(mapped="id")
  public Integer id;

  @Column(name="descricao")
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
