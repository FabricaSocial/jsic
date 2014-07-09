package models.pessoa.funcionario;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CoordenadoriaAjunta")
public class CoordenadoriaAdjunta extends Model
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

  @ManyToOne
  @JoinColumn(name="coordenadoria_id", referencedColumnName="id")
  private Coordenadoria coordenadoria;

  public CoordenadoriaAdjunta()
  {
    this.descricao = "";
    this.abreviacao = "";
    this.coordenadoria = new Coordenadoria();
  }

  public Integer getId() { return this.id; }
  public void setId(Integer id) { this.id = id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
  public String getAbreviacao() { return this.abreviacao; }
  public void setAbreviacao(String abreviacao) { this.abreviacao = abreviacao; }
  public Coordenadoria getCoordenadoria() { return this.coordenadoria; }
  public void setCoordenadoria(Coordenadoria coordenadoria) { this.coordenadoria = coordenadoria; }

  public String toString()
  {
    return getDescricao();
  }

  public static Finder<Integer,CoordenadoriaAdjunta> find =
    new Finder<Integer,CoordenadoriaAdjunta>(Integer.class,CoordenadoriaAdjunta.class);
}