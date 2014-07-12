package models.ponto;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import models.Usuario;
import models.pessoa.capacitando.Capacitando;
import play.db.ebean.Model;

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
  private Date data;

  @Column(name="hora")
  private Time hora;

  @ManyToOne
  @JoinColumn(name="tipo_ponto_id", referencedColumnName="id")
  private TipoPonto tipoPonto;

  @ManyToOne
  @JoinColumn(name="capacitando_id", referencedColumnName="id")
  private Capacitando capacitando;

  @ManyToOne
  @JoinColumn(name="usuario_id", referencedColumnName="id")
  private Usuario usuario;

  public Ponto()
  {
    this.data = new Date();
    this.hora = new Time(System.currentTimeMillis());
    this.tipoPonto = new TipoPonto();
    this.capacitando = new Capacitando();
    this.usuario = new Usuario();
  }

  public Integer getId() { return this.id; }
  public void setId(Integer id) { this.id = id; }
  public Date getData() { return this.data; }
  public void setData(Date data) { this.data = data; }
  public Time getHora() { return this.hora; }
  public void setHora(Time hora) { this.hora = hora; }
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

  public static Finder<Integer,Ponto> find =
    new Finder<Integer,Ponto>(Integer.class,Ponto.class);
}
