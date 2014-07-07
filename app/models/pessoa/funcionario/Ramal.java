package models.pessoa.funcionario;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name="Ramal")
public class Ramal extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="ramal")
  private Integer ramal;

  @ManyToMany(mappedBy="listaRamais")
  private List<Lotacao> listaLotacoes;

  public Ramal()
  {
    this.ramal = 0;
  }

  public Integer getId() { return this.id; }
  public Integer getRamal() { return this.ramal; }
  public void setRamal(Integer ramal) { this.ramal = ramal; }
  public List<Lotacao> getListaLotacoes() { return this.listaLotacoes; }
  public void setListaLotacoes(List<Lotacao> listaLotacoes) { this.listaLotacoes = listaLotacoes; }

  public String toString()
  {
    return getRamal().toString();
  }

  public static Finder<Integer,Ramal> find =
    new Finder<Integer,Ramal>(Integer.class,Ramal.class);
}
