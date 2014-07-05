package models.funcionario;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name="Lotacao")
public class Lotacao extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="descricao")
  private String descricao;

  @ManyToMany
  @JoinTable(name="LotacaoRamal", joinColumns={ @JoinColumn(name="lotacao_id") }
    , inverseJoinColumns={ @JoinColumn(name="cliente_id") })
  private List<Ramal> listaRamais;

  public Lotacao()
  {
    this.descricao = "";
  }

  public Integer getId() { return this.id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
  public List<Ramal> getListaRamais() { return this.listaRamais; }
  public void setListaRamais(List<Ramal> listaRamais) { this.listaRamais = listaRamais; }

  public String toString()
  {
    return getDescricao();
  }

  public static Finder<Integer,Lotacao> find =
    new Finder<Integer,Lotacao>(Integer.class,Lotacao.class);
}
