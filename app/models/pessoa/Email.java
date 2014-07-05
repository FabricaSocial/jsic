package models.pessoa;

import play.db.ebean.Model;

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
@Table(name="Email")
public class Email extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="endereco")
  private String endereco;

  @ManyToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  public Email()
  {
    this.endereco = "";
    this.pessoa = new Pessoa();
  }

  public Integer getId() { return this.id; }
  public String getEndereco() { return this.endereco; }
  public void setEndereco(String endereco) { this.endereco = endereco; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

  public String toString()
  {
    return getEndereco();
  }

  public static Finder<Integer,Email> find =
    new Finder<Integer,Email>(Integer.class,Email.class);
}
