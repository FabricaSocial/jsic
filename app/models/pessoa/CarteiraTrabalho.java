package models.pessoa;

import play.db.ebean.Model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="CarteiraTrabalho")
public class CarteiraTrabalho extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="ctps")
  private BigInteger ctps;

  @Column(name="serie")
  private Integer serie;

  @OneToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  public CarteiraTrabalho()
  {
    this.ctps = BigInteger.valueOf(0);
    this.serie = 0;
    this.pessoa = new Pessoa();
  }

  public Integer getId() { return this.id; }
  public BigInteger getCtps() { return this.ctps; }
  public void setCtps(BigInteger ctps) { this.ctps = ctps; }
  public Integer getSerie() { return this.serie; }
  public void setSerie(Integer serie) { this.serie = serie; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

  public String toString()
  {
    return getCtps().toString();
  }

  public static Finder<Integer,CarteiraTrabalho> find =
    new Finder<Integer,CarteiraTrabalho>(Integer.class,CarteiraTrabalho.class);
}
