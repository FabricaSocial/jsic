package models.pessoa;

import play.db.ebean.Model;

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
@Table(name="Telefone")
public class Telefone extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="numero")
  private BigInteger numero;

  @ManyToOne
  @JoinColumn(name="tipo_telefone_id", referencedColumnName="id")
  private TipoTelefone tipoTelefone;

  @ManyToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  public Telefone()
  {
    this.numero = 0;
    this.tipoTelefone = new TipoTelefone();
    this.pessoa = new Pessoa();
  }

  public Integer getId() { return this.id; }
  public BigInteger getNumero() { return this.numero; }
  public void setNumero(BigInteger numero) { this.numero = numero; }
  public TipoTelefone getTipoTelefone() { return this.tipoTelefone; }
  public void setTipoTelefone(TipoTelefone tipoTelefone) { this.tipoTelefone = tipoTelefone; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

  public Model.Finder<Integer,Telefone> find =
    new Model.Finder<Integer,Telefone>(Integer.class,Telefone.class);
}
