package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class UF extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  public String abreviacao;

  public Pais pais;

  public String nome;

  public UF()
  {
    this.abreviacao = "";
    this.pais = new Pais();
    this.nome = "";
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getAbreviacao()
  {
    return this.abreviacao;
  }

  public Pais getPais()
  {
    return this.pais;
  }

  public String getNome()
  {
    return this.nome;
  }

  public void setAbreviacao(String abreviacao)
  {
    this.abreviacao = abreviacao;
  }

  public void setPais(Pais pais)
  {
    this.pais = pais;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public String toString()
  {
    return getNome() + ", " + getAbreviacao() + " - " + getPais().toString();
  }

  public Model.Finder<Integer,UF> find =
    new Model.Finder<Integer,UF>(Integer.class,UF.class);
}
