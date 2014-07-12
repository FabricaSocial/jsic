package controllers.pessoa.funcionario;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.Secured;
import controllers.pessoa.funcionario.DepartamentoController;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import models.pessoa.funcionario.Departamento;
import models.pessoa.funcionario.Funcionario;
import play.data.Form;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.atualizarDados;

import static play.data.Form.form;

public class FuncionarioController extends Controller
{
  /**
   * Lista os telefones de todos os funcionários
   *
   * @return a lista de funcionários a ser utilizada na view
   */

  @Security.Authenticated(Secured.class)
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
  @Security.Authenticated(Secured.class)
  public static Result alterarDados()
  {
    Form<Funcionario> formFuncionario = form(Funcionario.class).bindFromRequest();

    Funcionario funcionarioNovo = formFuncionario.get();

    Funcionario funcionarioAntigo =  obterFuncionarioPorCPF(funcionarioNovo.getPessoa().getCpf());

    if(funcionarioAntigo != null)
    {
      funcionarioNovo.setId(funcionarioAntigo.getId());

      funcionarioNovo.save();

      return TODO;
    }

    return TODO;
  }

  @Security.Authenticated(Secured.class)
  public static Result formularioFuncionario()
  {
    Funcionario funcionarioConectado = obterFuncionarioPorNomeUsuario(session("conectado"));

    Form<Funcionario> formFuncionario = Form.form(Funcionario.class);

    formFuncionario = formFuncionario.fill(funcionarioConectado);

    return ok(atualizarDados.render(formFuncionario));
  }

  @Security.Authenticated(Secured.class)
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

  private static Funcionario obterFuncionarioPorCPF(BigInteger cpf)
  {
    return Funcionario.find.where().eq("pessoa.cpf", cpf).findUnique();
  }

  private static Funcionario obterFuncionarioPorNomeUsuario(String nomeUsuario)
  {
    return Funcionario.find.where().eq("usuario.nomeUsuario", nomeUsuario).findUnique();
  }
}