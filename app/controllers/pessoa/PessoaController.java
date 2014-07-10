package controllers.pessoa;

import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigInteger;
import java.util.List;
import models.pessoa.Pessoa;
import play.data.Form;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import static play.data.Form.form;

public class PessoaController extends Controller
{
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

  /**
   * Obtem pessoa a partir de seu CPF
   *
   * @param cpf o CPF da pessoa que se deseja localizar
   * @return a pessoa que deseja obter a partir do CPF ou badRequest, em caso de erro
   */
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
  @BodyParser.Of(BodyParser.Json.class)
  public static Result obtemPessoaJSON()
  {
    JsonNode json = request().body().asJson();
    String nome = json.findPath("nome").textValue();

    List<Pessoa> listaPessoas = pesquisaPessoaPorNome(nome);

    System.out.println(listaPessoas.toString());
    return ok(listaPessoas.toString());
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