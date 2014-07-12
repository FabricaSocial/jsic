package models.pessoa.capacitando;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import play.db.ebean.Model;

@Entity
@Table(name="Turno")
public class Turno extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="descricao")
  private String descricao;

  @Column(name="entrada")
  private Time entrada;

  @Column(name="entrada_tolerancia")
  private Time entradaTolerancia;

  @Column(name="saida_lanche")
  private Time saidaLanche;

  @Column(name="saida_lanche_tolerancia")
  private Time saidaLancheTolerancia;

  @Column(name="entrada_lanche")
  private Time entradaLanche;

  @Column(name="entrada_lanche_tolerancia")
  private Time entradaLancheTolerancia;

  @Column(name="saida")
  private Time saida;

  @Column(name="saida_tolerancia")
  private Time saidaTolerancia;

  public Turno()
  {
    this.descricao = "";
    this.entrada = new Time(System.currentTimeMillis());
    this.entradaTolerancia = new Time(System.currentTimeMillis());
    this.saidaLanche = new Time(System.currentTimeMillis());
    this.saidaLancheTolerancia = new Time(System.currentTimeMillis());
    this.entradaLanche = new Time(System.currentTimeMillis());
    this.entradaLancheTolerancia = new Time(System.currentTimeMillis());
    this.saida = new Time(System.currentTimeMillis());
    this.saidaTolerancia = new Time(System.currentTimeMillis());
  }

  public Integer getId() { return this.id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
  public Time getEntrada() { return this.entrada; }
  public void setEntrada(Time entrada) { this.entrada = entrada; }
  public Time getEntradaTolerancia() { return this.entradaTolerancia; }
  public void setEntradaTolerancia(Time entradaTolerancia) { this.entradaTolerancia = entradaTolerancia; }
  public Time getSaidaLanche() { return this.saidaLanche; }
  public void setSaidaLanche(Time aidaLanche) { this.saidaLanche = aidaLanche; }
  public Time getSaidaLancheTolerancia() { return this.saidaLancheTolerancia; }
  public void setSaidaLancheTolerancia(Time aidaLancheTolerancia) { this.saidaLancheTolerancia = aidaLancheTolerancia; }
  public Time getEntradaLanche() { return this.entradaLanche; }
  public void setEntradaLanche(Time entradaLanche) { this.entradaLanche = entradaLanche; }
  public Time getEntradaLancheTolerancia() { return this.entradaLancheTolerancia; }
  public void setEntradaLancheTolerancia(Time entradaLancheTolerancia) { this.entradaLancheTolerancia = entradaLancheTolerancia; }
  public Time getSaida() { return this.saida; }
  public void setSaida(Time aida) { this.saida = aida; }
  public Time getSaidaTolerancia() { return this.saidaTolerancia; }
  public void setSaidaTolerancia(Time aidaTolerancia) { this.saidaTolerancia = aidaTolerancia; }

  public String toString()
  {
    return getDescricao();
  }

  public static Finder<Integer,Turno> find =
    new Finder<Integer,Turno>(Integer.class,Turno.class);
}
