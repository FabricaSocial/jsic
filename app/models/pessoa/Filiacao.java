package models.pessoa;

import play.db.ebean.Model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Filiacao")
public class Filiacao extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="cpf")
  private BigInteger cpf;

  @Column(name="nome")
  private String nome;

  @ManyToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  public Filiacao()
  {
    this.cpf = BigInteger.valueOf(0);
    this.nome = "";
    this.pessoa = new Pessoa();
  }

  public Integer getId() { return this.id; }
  public BigInteger getCpf() { return this.cpf; }
  public void setCpf(BigInteger cpf) { this.cpf = cpf; }
  public String getNome() { return this.nome; }
  public void setNome(String nome) { this.nome = nome; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

  public String toString()
  {
    return getNome();
  }

  public Model.Finder<Integer,Filiacao> find =
    new Model.Finder<Integer,Filiacao>(Integer.class,Filiacao.class);
}
