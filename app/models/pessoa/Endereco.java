package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Endereco extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="cep")
  private BitInteger cep;

  @Column(name="endereco")
  private String endereco;

  @Column(name="bairro")
  private String bairro;

  @OneToMany
  @JoinColumn(name="cidade_id", referencedColumnName="id")
  private Cidade cidade;


  public Integer getId() { return this.id; }
  public BitInteger getCep() { return this.cep; }
  public void setCep(BitInteger cep) { this.cep = cep; }
  public String getEndereco() { return this.endereco; }
  public void setEndereco(String endereco) { this.endereco = endereco; }
  public String getBairro() { return this.bairro; }
  public void setBairro(String bairro) { this.bairro = bairro; }
  public Cidade getCidade() { return this.cidade; }
  public void setCidade(Cidade cidade) { this.cidade = cidade; }

  public String toString()
  {
    return getEndereco() + ", " + getBairro() + ", " getCep() + ", " +
       getCidade().toString();
  }
}