package models.pessoa.capacitando;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.pessoa.Cidade;

@Entity
@Table(name="Unidade")
public class Unidade extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name="cidade_id", referencedColumnName="id")
  private Cidade cidade;

  public Unidade()
  {
    this.cidade = new Cidade();
  }

  public Integer getId() { return this.id; }
  public Cidade getCidade() { return this.cidade; }
  public void setCidade(Cidade cidade) { this.cidade = cidade; }

  public String toString()
  {
    return getId().toString() + " - " + getCidade().toString();
  }

  public static Finder<Integer,Unidade> find =
    new Finder<Integer,Unidade>(Integer.class,Unidade.class);
}
