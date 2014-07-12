package controllers.pessoa.funcionario;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.pessoa.funcionario.DepartamentoController;
import java.util.ArrayList;
import java.util.List;
import models.pessoa.funcionario.Departamento;
import models.pessoa.funcionario.Funcionario;
import play.db.ebean.*;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

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
   * Altera os dados de uma pessoa existente, recebendo os dados de um formulário na tela
   *
   * @return retorna para painel de opções ou página de alteração de dados de pessoa, caso haja erro
   */
  public static Result alterarDados()
  {
    Form<Pessoa> formPessoa = form(Pessoa.class).bindFromRequest();

    Pessoa pessoaNova = formPessoa.get();

    Pessoa pessoaAntiga =  pesquisaPessoaPorCPF(pessoaNova.getCpf());

    if(pessoaAntiga != null)
    {
      pessoaNova.save();

      return TODO;
    }

    return TODO;
  }

  @BodyParser.Of(BodyParser.Json.class)
  public static Result obterFuncionariosJSON(String nome)
  {
    ObjectNode retornoJson = Json.newObject();
    List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

    if(nome != null)
    {
      listaFuncionarios = obterFuncionariosPorNome(nome);

      if(listaFuncionarios.isEmpty())
      {
        return badRequest(retornoJson);
      }

      JsonNode listaFuncionariosJson = Json.toJson(listaFuncionarios);

      retornoJson.put("funcionarios", listaFuncionariosJson);

      return ok(retornoJson);
    }

    return badRequest(retornoJson);
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

  private static List<Funcionario> obterFuncionariosPorNome(String nome)
  {
    List<Funcionario> listaFuncionarios = Funcionario.find.where("pessoa.nome like '%" + nome + "%'").findList();

    return listaFuncionarios;
  }
}