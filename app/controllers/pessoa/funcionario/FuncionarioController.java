package controllers.pessoa.funcionario;

import play.mvc.Controller;
import play.mvc.Result;
import play.db.ebean.*;


import java.util.List;

import models.pessoa.funcionario.Departamento;
import models.pessoa.funcionario.Funcionario;

import controllers.pessoa.funcionario.DepartamentoController;

public class FuncionarioController extends Controller
{
  /**
   * Lista os telefones de todos os funcionários
   *
   * @return a lista de funcionários a ser utilizada na view
   */
  public static Result listar_telefones()
  {
    return ok(
        views.html.listaTelefonica.render(obterListaFuncionarios())
    );
  }

  /**
   * Obtem a lista de todos os funcionários
   *
   * @return lista contendo todos os funcionários
   */
  private static List<Funcionario> obterListaFuncionarios()
  {
    List<Funcionario> listaFuncionarios = Funcionario.find
      .orderBy("departamento_id").findList();

    return listaFuncionarios;
  }

  private static List<List> obterFuncionariosPorDepartamento()
  {
    List<List> funcionariosPorDepartamento = null;
    for(Departamento departamento : DepartamentoController.obterListaDepartamento())
    {
      List<Funcionario> funcionariosNoDepartamento = Funcionario.find.where()
        .eq("departamento_id", departamento.getId()).findList();
      funcionariosPorDepartamento.add(funcionariosNoDepartamento);
    }

    return funcionariosPorDepartamento;
  }
}