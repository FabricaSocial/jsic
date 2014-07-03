package models.ponto;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoPonto")
public class TipoPonto extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="descricao")
  private String descricao;

  public TipoPonto()
  {
    this.descricao = "";
  }

  public Integer getId() { return this.id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }

  public String toString()
  {
    return getDescricao();
  }

  public static Finder<Integer,TipoPonto> find =
    new Finder<Integer,TipoPonto>(Integer.class,TipoPonto.class);
}
