package models.pessoa.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.pessoa.capacitando.Unidade;

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
  @JoinColumn(name="unidade_id", referencedColumnName="id")
  private Unidade unidade;

  public Departamento()
  {
    this.descricao = "";
    this.abreviacao = "";
    this.unidade = new Unidade();
  }

  public Integer getId() { return this.id; }
  public void setId(Integer id) { this.id = id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
  public String getAbreviacao() { return this.abreviacao; }
  public void setAbreviacao(String abreviacao) { this.abreviacao = abreviacao; }
  public Unidade getUnidade() { return this.unidade; }
  public void setUnidade(Unidade unidade) { this.unidade = unidade; }

  public String toString()
  {
    return getAbreviacao() + " - " + getDescricao();
  }

  public static Finder<Integer,Departamento> find =
    new Finder<Integer,Departamento>(Integer.class,Departamento.class);
}