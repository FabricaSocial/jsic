package models.pessoa;

import play.db.ebean.Model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reservista")
public class Reservista extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="certificado")
  private BigInteger certificado;

  @Column(name="serie")
  private BigInteger serie;

  @Column(name="orgao")
  private String orgao;

  @Column(name="dispensa_incorporacao")
  private BigInteger dispensaIncorporacao;

  @Column(name="unidade_alistamento")
  private String unidadeAlistamento;

  @OneToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  public Reservista()
  {
    this.certificado = BigInteger.valueOf(0);
    this.serie = BigInteger.valueOf(0);
    this.orgao = "";
    this.dispensaIncorporacao = BigInteger.valueOf(0);
    this.unidadeAlistamento = "";
    this.pessoa = new Pessoa();
  }

  public Integer getId() { return this.id; }
  public BigInteger getCertificado() { return this.certificado; }
  public void setCertificado(BigInteger certificado) { this.certificado = certificado; }
  public BigInteger getSerie() { return this.serie; }
  public void setSerie(BigInteger serie) { this.serie = serie; }
  public String getOrgao() { return this.orgao; }
  public void setOrgao(String orgao) { this.orgao = orgao; }
  public BigInteger getDispensaIncorporacao() { return this.dispensaIncorporacao; }
  public void setDispensaIncorporacao(BigInteger dispensaIncorporacao) { this.dispensaIncorporacao = dispensaIncorporacao; }
  public String getUnidadeAlistamento() { return this.unidadeAlistamento; }
  public void setUnidadeAlistamento(String unidadeAlistamento) { this.unidadeAlistamento = unidadeAlistamento; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

  public String toString()
  {
    return getCertificado().toString();
  }

  public static Finder<Integer,Reservista> find =
    new Finder<Integer,Reservista>(Integer.class,Reservista.class);
}
