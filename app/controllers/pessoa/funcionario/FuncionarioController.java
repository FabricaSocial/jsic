package controllers.pessoa.funcionario;

import play.mvc.Controller;
import play.mvc.Result;
import play.db.ebean.*;

import java.util.ArrayList;
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
    List<Departamento> departamentos = DepartamentoController.obterListaDepartamento();
    List<List<Funcionario>> funcionarios = obterFuncionariosPorDepartamento();
    return ok(
        views.html.listaTelefonica.render(departamentos, funcionarios)
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

  private static List<List<Funcionario> > obterFuncionariosPorDepartamento()
  {
    List<List<Funcionario> > funcionariosPorDepartamento = new ArrayList<List<Funcionario> >();
    for(Departamento departamento : DepartamentoController.obterListaDepartamento())
    {
      List<Funcionario> funcionariosNoDepartamento = Funcionario.find.where()
        .eq("departamento_id", departamento.getId()).findList();
      funcionariosPorDepartamento.add(funcionariosNoDepartamento);
    }

    return funcionariosPorDepartamento;
  }
}