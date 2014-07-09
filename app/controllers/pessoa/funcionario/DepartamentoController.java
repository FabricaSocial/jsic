package controllers.pessoa.funcionario;

import play.mvc.Controller;

import java.util.List;

import models.pessoa.funcionario.Departamento;

public class DepartamentoController extends Controller
{

  public static List<Departamento> obterListaDepartamento()
  {
    List<Departamento> listaDepartamento = Departamento.find.all();

    return listaDepartamento;
  }
}