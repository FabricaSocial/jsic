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
@Table(name="TipoTelefone")
public class TipoTelefone extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  @Column(name="descricao")
  public String descricao;

  public TipoTelefone()
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

  public static Finder<Integer,TipoTelefone> find =
    new Finder<Integer,TipoTelefone>(Integer.class,TipoTelefone.class);
}
