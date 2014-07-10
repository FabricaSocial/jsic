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
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="Pessoa")
public class Pessoa extends Model
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

  @Column(name="data_nascimento")
  private Date dataNascimento;

  @Column(name="sexo")
  private Boolean sexo;

  @Column(name="filhos")
  private Boolean filhos;

  @Column(name="foto")
  private String foto;

  @ManyToOne
  @JoinColumn(name="etnia_id", referencedColumnName="id")
  private Etnia etnia;

  @ManyToOne
  @JoinColumn(name="tipo_identidade_id", referencedColumnName="id")
  private TipoIdentidade tipoIdentidade;

  @ManyToOne
  @JoinColumn(name="estado_civil_id", referencedColumnName="id")
  private EstadoCivil estadoCivil;

  @ManyToOne
  @JoinColumn(name="endereco_id", referencedColumnName="id")
  private Endereco endereco;

  @ManyToOne
  @JoinColumn(name="nacionalidade_id", referencedColumnName="id")
  private Nacionalidade nacionalidade;

  @ManyToOne
  @JoinColumn(name="naturalidade_id", referencedColumnName="id")
  private Naturalidade naturalidade;

  public Pessoa()
  {
    this.cpf = BigInteger.valueOf(0);
    this.nome = "";
    this.dataNascimento = new Date();
    this.sexo = false;
    this.filhos = false;
    this.foto = "";
    this.etnia = new Etnia();
    this.tipoIdentidade = new TipoIdentidade();
    this.estadoCivil = new EstadoCivil();
    this.nacionalidade = new Nacionalidade();
    this.naturalidade = new Naturalidade();
  }

  public Integer getId() { return this.id; }
  public void setId(Integer id) { this.id = id; }
  public BigInteger getCpf() { return this.cpf; }
  public void setCpf(BigInteger cpf) { this.cpf = cpf; }
  public String getNome() { return this.nome; }
  public void setNome(String nome) { this.nome = nome; }
  public Date getDataNascimento() { return this.dataNascimento; }
  public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }
  public Boolean getSexo() { return this.sexo; }
  public void setSexo(Boolean sexo) { this.sexo = sexo; }
  public Boolean getFilhos() { return this.filhos; }
  public void setFilhos(Boolean filhos) { this.filhos = filhos; }
  public String getFoto() { return this.foto; }
  public void setFoto(String foto) { this.foto = foto; }
  public Etnia getEtnia() { return this.etnia; }
  public void setEtnia(Etnia etnia) { this.etnia = etnia; }
  public TipoIdentidade getTipoIdentidade() { return this.tipoIdentidade; }
  public void setTipoIdentidade(TipoIdentidade tipoIdentidade) { this.tipoIdentidade = tipoIdentidade; }
  public EstadoCivil getEstadoCivil() { return this.estadoCivil; }
  public void setEstadoCivil(EstadoCivil estadoCivil) { this.estadoCivil = estadoCivil; }
  public Endereco getEndereco() { return this.endereco; }
  public void setEndereco(Endereco endereco) { this.endereco = endereco; }
  public Nacionalidade getNacionalidade() { return this.nacionalidade; }
  public void setNacionalidade(Nacionalidade nacionalidade) { this.nacionalidade = nacionalidade; }
  public Naturalidade getNaturalidade() { return this.naturalidade; }
  public void setNaturalidade(Naturalidade naturalidade) { this.naturalidade = naturalidade; }

  public String toString()
  {
    return getNome();
  }

  public static Finder<Integer,Pessoa> find =
    new Finder<Integer,Pessoa>(Integer.class,Pessoa.class);
}
