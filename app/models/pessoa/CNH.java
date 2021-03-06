package models.pessoa;

import java.math.BigInteger;
import java.util.Date;
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
@Table(name="CNH")
public class CNH extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="numero")
  private BigInteger numero;

  @Column(name="data_emissao")
  private Date dataEmissao;

  @Column(name="validade")
  private Date validade;

  @ManyToOne
  @JoinColumn(name="uf_id", referencedColumnName="id")
  private UF uf;

  @ManyToOne
  @JoinColumn(name="categoria_cnh_id", referencedColumnName="id")
  private CategoriaCNH categoriaCNH;

  @OneToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  public CNH()
  {
    this.numero = BigInteger.valueOf(0);
    this.dataEmissao = new Date();
    this.validade = new Date();
    this.uf = new UF();
    this.categoriaCNH = new CategoriaCNH();
    this.pessoa = new Pessoa();
  }

  public Integer getId() { return this.id; }
  public BigInteger getNumero() { return this.numero; }
  public void setNumero(BigInteger numero) { this.numero = numero; }
  public Date getDataEmissao() { return this.dataEmissao; }
  public void setDataEmissao(Date dataEmissao) { this.dataEmissao = dataEmissao; }
  public Date getValidade() { return this.validade; }
  public void setValidade(Date validade) { this.validade = validade; }
  public UF getUF() { return this.uf; }
  public void setUF(UF uf) { this.uf = uf; }
  public CategoriaCNH getCategoriaCNH() { return this.categoriaCNH; }
  public void setCategoriaCNH(CategoriaCNH categoriaCNH) { this.categoriaCNH = categoriaCNH; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

  public String toString()
  {
    return getNumero().toString();
  }

  public static Finder<Integer,CNH> find =
    new Finder<Integer,CNH>(Integer.class,CNH.class);
}
