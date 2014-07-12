package models.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import play.db.ebean.Model;

@Entity
@Table(name="Nacionalidade")
public class Nacionalidade extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  @Column(name="descricao")
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

  public static Finder<Integer,Nacionalidade> find =
    new Finder<Integer,Nacionalidade>(Integer.class,Nacionalidade.class);
}
