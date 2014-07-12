package models.pessoa.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import play.db.ebean.Model;

@Entity
@Table(name="Coordenadoria")
public class Coordenadoria extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="descricao")
  private String descricao;

  @Column(name="abreviacao")
  private String abreviacao;

  public Coordenadoria()
  {
    this.descricao = "";
    this.abreviacao = "";
  }

  public Integer getId() { return this.id; }
  public void setId(Integer id) { this.id = id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
  public String getAbreviacao() { return this.abreviacao; }
  public void setAbreviacao(String abreviacao) { this.abreviacao = abreviacao; }

  public String toString()
  {
    return getDescricao();
  }

  public static Finder<Integer,Coordenadoria> find =
    new Finder<Integer,Coordenadoria>(Integer.class,Coordenadoria.class);
}