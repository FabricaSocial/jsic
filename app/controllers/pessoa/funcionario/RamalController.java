package controllers.pessoa.funcionario;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import models.pessoa.funcionario.Ramal;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import controllers.Secured;
import play.mvc.Security;

public class RamalController extends Controller
{

  @Security.Authenticated(Secured.class)
  @BodyParser.Of(BodyParser.Json.class)
  public static Result obterRamaisJSON(String nome)
  {
    ObjectNode retornoJson = Json.newObject();
    List<Ramal> listaRamais = new ArrayList<Ramal>();

    if(nome != null)
    {
      listaRamais = obterRamaisPorNomeDepartamento(nome);

      if(listaRamais.isEmpty())
      {
        return badRequest(retornoJson);
      }

      JsonNode listaRamaisJson = Json.toJson(listaRamais);

      retornoJson.put("ramais", listaRamaisJson);

      return ok(retornoJson);
    }

    return badRequest(retornoJson);
  }

  private static List<Ramal> obterRamaisPorNomeDepartamento(String nome)
  {
    List<Ramal> listaRamais = Ramal.find.where("departamento.descricao like '%" + nome + "%'").findList();

    return listaRamais;
  }
}