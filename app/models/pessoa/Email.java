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
@Table(name="Email")
public class Email extends Model
{
  private static final long serialVersionUID = 1L;

  private Integer id;

  private String endereco;

  private Pessoa pessoa;

  public Email()
  {
    this.endereco = "";
    this.pessoa = new Pessoa();
  }

  public Integer getId() { return _id; }
  public String getEndereco() { return _endereco; }
  public void setEndereco(String endereco) { _endereco = endereco; }
  public Pessoa getPessoa() { return _pessoa; }
  public void setPessoa(Pessoa pessoa) { _pessoa = pessoa; }

  public Model.Finder<Integer,Email> find =
    new Model.Finder<Integer,Email>(Integer.class,Email.class);
}
