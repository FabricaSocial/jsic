package controllers.pessoa;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.Secured;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import models.pessoa.Pessoa;
import play.data.Form;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import static play.data.Form.form;

public class PessoaController extends Controller
{
  /**
   * Obtem pessoa a partir de seu CPF
   *
   * @param cpf o CPF da pessoa que se deseja localizar
   * @return a pessoa que deseja obter a partir do CPF ou badRequest, em caso de erro
   */

  @Security.Authenticated(Secured.class)
  public static Result obtemPessoa(BigInteger cpf)
  {
    Pessoa pessoa = pesquisaPessoaPorCPF(cpf);

    if(pessoa == null)
    {
      return TODO;
    }

    return TODO;
  }

  /**
   * Realiza pesquisa de pessoa através do nome e obtem um JSON uma lista de dados
   *
   * @return objeto json de pessoa, por pesquisa através do nome
   */

  @Security.Authenticated(Secured.class)
  @BodyParser.Of(BodyParser.Json.class)
  public static Result obterPessoasJSON(String nome)
  {
    ObjectNode retornoJson = Json.newObject();
    List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    if(nome != null)
    {
      listaPessoas = pesquisaPessoaPorNome(nome);

      if(listaPessoas.isEmpty())
      {
        return badRequest(retornoJson);
      }

      JsonNode listaPessoasJson = Json.toJson(listaPessoas);

      retornoJson.put("pessoas", listaPessoasJson);

      return ok(retornoJson);
    }

    return badRequest(retornoJson);
  }

  /**
   * Realiza a pesquisa de pessoa por CPF
   *
   * @param cpf o CPF da pessoa que se deseja localizar
   * @return a pessoa localizada ou null, caso haja erro
   */
  private static Pessoa pesquisaPessoaPorCPF(BigInteger cpf)
  {
    return Pessoa.find.where().eq("cpf",cpf).findUnique();
  }

  /**
   * Realiza a pesquisa por parte de nome em Pessoa
   *
   * @param nome a parte do nome a ser usada na pesquisa por nome
   * @return lista de pessoas que possuem a parte do nome informada no nome
   */
  private static List<Pessoa> pesquisaPessoaPorNome(String nome)
  {
    return Pessoa.find.where("nome like '%" + nome + "%'").findList();
  }
}