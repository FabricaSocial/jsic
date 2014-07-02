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
@Table(name="Naturalidade")
public class Naturalidade extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name="pais_id", referencedColumnName="id")
  private Pais pais;

  @ManyToOne
  @JoinColumn(name="cidade_id", referencedColumnName="id")
  private Cidade cidade;

  @ManyToOne
  @JoinColumn(name="uf_id", referencedColumnName="id")
  private UF uf;

  public Naturalidade()
  {
    this.pais = new Pais();
    this.cidade = new Cidade();
    this.uf = new UF();
  }

  public Integer getId() { return this.id; }
  public Pais getPais() { return this.pais; }
  public void setPais(Pais pais) { this.pais = pais; }
  public Cidade getCidade() { return this.cidade; }
  public void setCidade(Cidade cidade) { this.cidade = cidade; }
  public UF getUF() { return this.uf; }
  public void setUF(UF uf) { this.uf = uf; }

  public String toString()
  {
    return getCidade().toString();
  }

  public static Finder<Integer,Naturalidade> find =
    new Finder<Integer,Naturalidade>(Integer.class,Naturalidade.class);
}
