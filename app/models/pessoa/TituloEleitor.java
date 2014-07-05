package models.pessoa;

import play.db.ebean.Model;

import java.math.BigInteger;

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
@Table(name="TituloEleitor")
public class TituloEleitor extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="titulo")
  private BigInteger titulo;

  @Column(name="zona")
  private Integer zona;

  @Column(name="secao")
  private Integer secao;

  @OneToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  @ManyToOne
  @JoinColumn(name="cidade_id", referencedColumnName="id")
  private Cidade cidade;

  public TituloEleitor()
  {
    this.titulo = BigInteger.valueOf(0);
    this.zona = 0;
    this.secao = 0;
    this.pessoa = new Pessoa();
    this.cidade = new Cidade();
  }

  public Integer getId() { return this.id; }
  public BigInteger getTitulo() { return this.titulo; }
  public void setTitulo(BigInteger titulo) { this.titulo = titulo; }
  public Integer getZona() { return this.zona; }
  public void setZona(Integer zona) { this.zona = zona; }
  public Integer getSecao() { return this.secao; }
  public void setSecao(Integer secao) { this.secao = secao; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
  public Cidade getCidade() { return this.cidade; }
  public void setCidade(Cidade cidade) { this.cidade = cidade; }

  public String toString()
  {
    return getTitulo().toString();
  }

  public static Finder<Integer,TituloEleitor> find =
    new Finder<Integer,TituloEleitor>(Integer.class,TituloEleitor.class);
}
