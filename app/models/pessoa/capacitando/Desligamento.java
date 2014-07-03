package models.pessoa.capacitando;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="Desligamento")
public class Desligamento extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="data")
  private LocalDate data;

  @OneToOne
  @JoinColumn(name="capacitando_id", referencedColumnName="id")
  private Capacitando capacitando;

  public Desligamento()
  {
    this.data = LocalDate.now();
    this.capacitando = new Capacitando();
  }

  public Integer getId() { return this.id; }
  public LocalDate getData() { return this.data; }
  public void setData(LocalDate data) { this.data = data; }
  public Capacitando getCapacitando() { return this.capacitando; }
  public void setCapacitando(Capacitando capacitando) { this.capacitando = capacitando; }

  public String toString()
  {
    return getCapacitando().toString() + " - " + getData().toString();
  }

  public static Finder<Integer,Desligamento> find =
    new Finder<Integer,Desligamento>(Integer.class,Desligamento.class);
}
