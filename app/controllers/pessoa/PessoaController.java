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

    Pessoa pessoa = formPessoa.get();

    pessoa = obterPessoaPorCPF(pessoa.getCpf());

    pessoa.save();
  }

  private static Pessoa obterPessoaPorCPF(BigInteger cpf)
  {
    return Pessoa.find.where().eq("cpf",cpf).findUnique();
  }
}