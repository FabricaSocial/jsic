package controllers.pessoa.funcionario;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import models.pessoa.funcionario.Funcionario;

public class FuncionarioController extends Controller
{
  /**
   * Obtem a lista de todos os funcionários
   *
   * @return lista contendo todos os funcionários
   */
  public static List<Funcionario> obterListaFuncionarios()
  {
    List<Funcionario> listaFuncionarios = Funcionario.find.all();

    return listaFuncionarios;
  }

  /**
   * Lista todos os funcionários
   *
   * @return a lista de funcionários a ser utilizada na view
   */
  public static Result listar()
  {
    System.out.println(obterListaFuncionarios());
    // return ok(
    //     views.html.listaTelefonica.render(obterListaFuncionarios())
    // );
    return TODO;
  }
}