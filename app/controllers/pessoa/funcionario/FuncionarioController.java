package controllers.pessoa.funcionario;

import play.mvc.Controller;
import play.mvc.Result;
import play.db.ebean.*;


import java.util.List;

import models.pessoa.funcionario.Funcionario;

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
    List<Funcionario> listaFuncionarios = Funcionario.find.all();

    return listaFuncionarios;
  }
}