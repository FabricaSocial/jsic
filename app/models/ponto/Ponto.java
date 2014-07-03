package models.ponto;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

import models.Usuario;
import models.pessoa.capacitando.Capacitando;

@Entity
@Table(name="Ponto")
public class Ponto extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="data")
  private LocalDate data;

  @Column(name="hora")
  private LocalTime hora;

  @ManyToOne
  @JoinColumn(name="tipo_ponto_id", referencedColumnName="id")
  private TipoPonto tipoPonto;

  @ManyToOne
  @JoinColumn(name="capacitando_id", referencedColumnName="id")
  private Capacitando capacitando;

  @ManyToOne
  @JoinColumn(name="user_id", referencedColumnName="id")
  private Usuario usuario;

  public Integer getId() { return this.id; }
  public void setId(Integer id) { this.id = id; }
  public LocalDate getData() { return this.data; }
  public void setData(LocalDate data) { this.data = data; }
  public LocalTime getHora() { return this.hora; }
  public void setHora(LocalTime hora) { this.hora = hora; }
  public TipoPonto getTipoPonto() { return this.tipoPonto; }
  public void setTipoPonto(TipoPonto tipoPonto) { this.tipoPonto = tipoPonto; }
  public Capacitando getCapacitando() { return this.capacitando; }
  public void setCapacitando(Capacitando capacitando) { this.capacitando = capacitando; }
  public Usuario getUsuario() { return this.usuario; }
  public void setUsuario(Usuario usuario) { this.usuario = usuario; }

  public String toString()
  {
    return getTipoPonto().toString() + " - " + getData().toString() + " "
    + getHora().toString() + " - " + getCapacitando().toString();
  }
}
