package models.pessoa;

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
import play.db.ebean.Model;

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

  public static Finder<Integer,Filiacao> find =
    new Finder<Integer,Filiacao>(Integer.class,Filiacao.class);
}
