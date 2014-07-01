package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="UF")
public class UF extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @OneToMany(mapped="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  @Column(name="abreviacao")
  public String abreviacao;

  @ManyToOne
  @JoinColumn(name="pais_id", referencedColumnName="id")
  public Pais pais;

  @Column(name="nome")
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
