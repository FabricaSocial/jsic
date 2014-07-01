package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Cidade extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @OneToMany(mapped="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name="uf_id", referencedColumnName="id")
  private UF uf;

  @Column(name="nome")
  private String nome;

  public Cidade()
  {
    this.uf = new UF();
    this.nome = "";
  }

  public Integer getId() { return this.id; }

  public UF getUF() { return this.uf; }

  public void setUF(UF uf) { this.uf = uf; }

  public String getNome() { return this.nome; }

  public void setNome(String nome) { this.nome = nome; }

  public String toString()
  {
    return getNome() + ", " + getUF().toString();
  }
}
