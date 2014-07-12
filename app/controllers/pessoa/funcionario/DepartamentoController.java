package controllers.pessoa.funcionario;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.Secured;
import java.util.ArrayList;
import java.util.List;
import models.pessoa.funcionario.Departamento;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

public class DepartamentoController extends Controller
{

  @Security.Authenticated(Secured.class)
  public static List<Departamento> obterListaDepartamento()
  {
    List<Departamento> listaDepartamento = Departamento.find.orderBy("id").findList();

    return listaDepartamento;
  }

  @Security.Authenticated(Secured.class)
  @BodyParser.Of(BodyParser.Json.class)
  public static Result obterDepartamentosJSON(String nome)
  {
    ObjectNode retornoJson = Json.newObject();
    List<Departamento> listaDepartamentos = new ArrayList<Departamento>();

    if(nome != null)
    {

      listaDepartamentos = obterListaDepartamentoPorNome(nome);

      if(listaDepartamentos.isEmpty())
      {
        return badRequest(retornoJson);
      }

      JsonNode listaDepartamentosJson = Json.toJson(listaDepartamentos);

      retornoJson.put("departamentos", listaDepartamentosJson);

      return ok(listaDepartamentosJson);
    }

    return badRequest(retornoJson);
  }

  private static List<Departamento> obterListaDepartamentoPorNome(String nome)
  {
    List<Departamento> listaDepartamento = Departamento.find.where("descricao like '%" + nome + "%'").findList();

    return listaDepartamento;
  }
}