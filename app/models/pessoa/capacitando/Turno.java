package models.pessoa.capacitando;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalTime;

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
  private LocalTime entrada;

  @Column(name="entrada_tolerancia")
  private LocalTime entradaTolerancia;

  @Column(name="saida_lanche")
  private LocalTime saidaLanche;

  @Column(name="saida_lanche_tolerancia")
  private LocalTime saidaLancheTolerancia;

  @Column(name="entrada_lanche")
  private LocalTime entradaLanche;

  @Column(name="entrada_lanche_tolerancia")
  private LocalTime entradaLancheTolerancia;

  @Column(name="saida")
  private LocalTime saida;

  @Column(name="saida_tolerancia")
  private LocalTime saidaTolerancia;

  public Turno()
  {
    this.descricao = "";
    this.entrada = LocalTime.now();
    this.entradaTolerancia = LocalTime.now();
    this.saidaLanche = LocalTime.now();
    this.saidaLancheTolerancia = LocalTime.now();
    this.entradaLanche = LocalTime.now();
    this.entradaLancheTolerancia = LocalTime.now();
    this.saida = LocalTime.now();
    this.saidaTolerancia = LocalTime.now();
  }

  public Integer getId() { return this.id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
  public LocalTime getEntrada() { return this.entrada; }
  public void setEntrada(LocalTime entrada) { this.entrada = entrada; }
  public LocalTime getEntradaTolerancia() { return this.entradaTolerancia; }
  public void setEntradaTolerancia(LocalTime entradaTolerancia) { this.entradaTolerancia = entradaTolerancia; }
  public LocalTime getSaidaLanche() { return this.saidaLanche; }
  public void setSaidaLanche(LocalTime aidaLanche) { this.saidaLanche = aidaLanche; }
  public LocalTime getSaidaLancheTolerancia() { return this.saidaLancheTolerancia; }
  public void setSaidaLancheTolerancia(LocalTime aidaLancheTolerancia) { this.saidaLancheTolerancia = aidaLancheTolerancia; }
  public LocalTime getEntradaLanche() { return this.entradaLanche; }
  public void setEntradaLanche(LocalTime entradaLanche) { this.entradaLanche = entradaLanche; }
  public LocalTime getEntradaLancheTolerancia() { return this.entradaLancheTolerancia; }
  public void setEntradaLancheTolerancia(LocalTime entradaLancheTolerancia) { this.entradaLancheTolerancia = entradaLancheTolerancia; }
  public LocalTime getSaida() { return this.saida; }
  public void setSaida(LocalTime aida) { this.saida = aida; }
  public LocalTime getSaidaTolerancia() { return this.saidaTolerancia; }
  public void setSaidaTolerancia(LocalTime aidaTolerancia) { this.saidaTolerancia = aidaTolerancia; }

  public String toString()
  {
    return getDescricao();
  }

  public static Finder<Integer,Turno> find =
    new Finder<Integer,Turno>(Integer.class,Turno.class);
}
