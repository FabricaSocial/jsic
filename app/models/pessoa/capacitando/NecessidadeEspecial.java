package models.pessoa.capacitando;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import play.db.ebean.Model;

@Entity
@Table(name="NecessidadeEspecial")
public class NecessidadeEspecial extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="descricao")
  private String descricao;

  public NecessidadeEspecial()
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

  public static Finder<Integer,NecessidadeEspecial> find =
    new Finder<Integer,NecessidadeEspecial>(Integer.class,NecessidadeEspecial.class);
}
