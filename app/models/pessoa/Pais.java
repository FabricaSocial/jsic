package models.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import play.db.ebean.Model;

@Entity
@Table(name="Pais")
public class Pais extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  @Column(name="nome")
  public String nome;

  public Pais()
  {
    this.nome = "";
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getNome()
  {
    return this.nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public String toString()
  {
    return getNome();
  }

  public static Finder<Integer,Pais> find =
    new Finder<Integer,Pais>(Integer.class,Pais.class);
}
