package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class EstadoCivil extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="descricao")
  private String descricao;


  public Integer getId() { return this.id; }
  public String getDescricao() { return this.descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
}