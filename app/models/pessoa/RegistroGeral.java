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

import java.util.Date;

@Entity
@Table(name="RegistroGeral")
public class RegistroGeral extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="rg")
  private BigInteger rg;

  @Column(name="orgao_expedidor")
  private String orgaoExpedidor;

  @Column(name="data_expedicao")
  private Date dataExpedicao;

  @OneToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  @ManyToOne
  @JoinColumn(name="uf_id", referencedColumnName="id")
  private UF uf;

  public RegistroGeral()
  {
    this.rg = BigInteger.valueOf(0);
    this.orgaoExpedidor = "";
    this.dataExpedicao = new Date();
    this.pessoa = new Pessoa();
    this.uf = new UF();
  }

  public Integer getId() { return this.id; }
  public BigInteger getRg() { return this.rg; }
  public void setRg(BigInteger rg) { this.rg = rg; }
  public String getOrgaoExpedidor() { return this.orgaoExpedidor; }
  public void setOrgaoExpedidor(String orgaoExpedidor) { this.orgaoExpedidor = orgaoExpedidor; }
  public Date getDataExpedicao() { return this.dataExpedicao; }
  public void setDataExpedicao(Date dataExpedicao) { this.dataExpedicao = dataExpedicao; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
  public UF getUF() { return this.uf; }
  public void setUF(UF uf) { this.uf = uf; }

  public String toString()
  {
    return getRg().toString();
  }

  public static Finder<Integer,RegistroGeral> find =
    new Finder<Integer,RegistroGeral>(Integer.class,RegistroGeral.class);
}
