package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ServicoMilitar")
public class ServicoMilitar extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="ano")
  private Integer ano;

  @OneToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  @ManyToOne
  @JoinColumn(name="uf_id", referencedColumnName="id")
  private UF uf;

  public ServicoMilitar()
  {
    this.ano = 0;
    this.pessoa = new Pessoa();
    this.uf = new UF();
  }

  public Integer getId() { return this.id; }
  public Integer getAno() { return this.ano; }
  public void setAno(Integer ano) { this.ano = ano; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
  public UF getUF() { return this.uf; }
  public void setUF(UF uf) { this.uf = uf; }

  public String toString()
  {
    return getAno() + ", " + getPessoa().toString();
  }

  public static Finder<Integer,ServicoMilitar> find =
    new Finder<Integer,ServicoMilitar>(Integer.class,ServicoMilitar.class);
}
