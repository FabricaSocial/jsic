package controllers.pessoa;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import java.math.BigInteger;

import models.pessoa.Pessoa;

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
   * Realiza a pesquisa de pessoa por CPF
   *
   * @param cpf o CPF da pessoa que se deseja localizar
   * @return a pessoa localizada ou null, caso haja erro
   */
  private static Pessoa pesquisaPessoaPorCPF(BigInteger cpf)
  {
    return Pessoa.find.where().eq("cpf",cpf).findUnique();
  }
}