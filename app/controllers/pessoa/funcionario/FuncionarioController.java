package controllers.pessoa.capacitando;

import play.mvc.Controller;

import java.util.List;

import models.pessoa.funcionario.Funcionario;

public class FuncionarioController extends Controller
{
  public static List<Funcionario> obterListaFuncionarios()
  {
    List<Funcionario> listaFuncionarios = Funcionario.find.findList();

    return listaFuncionarios;
  }

  public static Result listar()
  {
    return ok(
        views.html.index.render(obterListaFuncionarios())
    );
  }
}