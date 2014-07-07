package models.pessoa.funcionario;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cargo")
public class Cargo extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="cargo_efetivo")
  private String cargoEfetivo;

  @ManyToOne
  @JoinColumn(name="lotacao_id", referencedColumnName="id")
  private Lotacao lotacao;

  public Cargo()
  {
    this.cargoEfetivo = "";
    this.lotacao = new Lotacao();
  }

  public Integer getId() { return this.id; }
  public String getCargoEfetivo() { return this.cargoEfetivo; }
  public void setCargoEfetivo(String cargoEfetivo) { this.cargoEfetivo = cargoEfetivo; }
  public Lotacao getLotacao() { return this.lotacao; }
  public void setLotacao(Lotacao lotacao) { this.lotacao = lotacao; }

  public String toString()
  {
    return getCargoEfetivo() + " - " + getLotacao().toString();
  }

  public static Finder<Integer,Cargo> find =
    new Finder<Integer,Cargo>(Integer.class,Cargo.class);
}
