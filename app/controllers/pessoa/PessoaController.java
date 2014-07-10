package controllers.pessoa;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import java.math.BigInteger;

import models.pessoa.Pessoa;

import static play.data.Form.form;

public class PessoaController extends Controller
{
  public static void alterarDados()
  {
    Form<Pessoa> formPessoa = form(Pessoa.class).bindFromRequest();

    Pessoa pessoaNova = formPessoa.get();

    pessoaAntiga =  pesquisaPessoaPorCPF(pessoa.getCpf());

    if(pessoaAntiga != null)
    {
      pessoaNova.save();
    }
  }

  public static Result obtemPessoa(BigInteger cpf)
  {
    Pessoa pessoa = pesquisaPessoaPorCPF(cpf);

    if(pessoa == null)
    {
      return TODO;
    }

    return TODO;
  }

  private static Pessoa pesquisaPessoaPorCPF(BigInteger cpf)
  {
    return Pessoa.find.where().eq("cpf",cpf).findUnique();
  }
}