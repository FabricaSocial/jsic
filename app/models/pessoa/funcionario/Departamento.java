package models.pessoa.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="Departamento")
public class Departamento extends Model
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
  @JoinColumn(name="coordenadoria_adjunta_id", referencedColumnName="id")
  private CoordenadoriaAdjunta coordenadoriaAdjunta;

  @Column(name="ramal")
  public Integer ramal;

  public Departamento()
  {
    this.descricao = "";
    this.abreviacao = "";
    this.coordenadoriaAdjunta = new CoordenadoriaAdjunta();
    this.ramal = 0;
  }

  public Integer getId() { return this.id; }
  public void setId(Integer id) { this.id = id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
  public String getAbreviacao() { return this.abreviacao; }
  public void setAbreviacao(String abreviacao) { this.abreviacao = abreviacao; }
  public CoordenadoriaAdjunta getCoordenadoriaAdjunta() { return this.coordenadoriaAdjunta; }
  public void setCoordenadoriaAdjunta(CoordenadoriaAdjunta coordenadoriaAdjunta) { this.coordenadoriaAdjunta = coordenadoriaAdjunta; }
  public Integer getRamal() { return this.ramal; }
  public void setRamal(Integer ramal) { this.ramal = ramal; }

  public String toString()
  {
    return getAbreviacao() + " - " + getDescricao();
  }

  public static Finder<Integer,Departamento> find =
    new Finder<Integer,Departamento>(Integer.class,Departamento.class);
}