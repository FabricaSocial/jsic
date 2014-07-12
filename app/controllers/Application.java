package controllers;

import play.Logger;
import play.data.Form;
import play.data.validation.Constraints;
import play.mvc.Controller;
import play.mvc.Result;

import models.Usuario;
import models.utils.AppException;

import views.html.index;
import views.html.dashboard;

import static play.data.Form.form;

public class Application extends Controller
{
  /**
   * Realiza o redirecionamento da página de login para
   * o dashboard
   *
   * @return redireciona para o dashboard ou recarrega a paǵina de login, caso haja erro no login
   */
  public static Result index()
  {
    if(verificarSessao())
    {
      return redirect( "/dashboard" );
    }
    else
    {
      limparSessao();
    }

    return ok(index.render(form(Login.class)));
  }

  public static Result sair()
  {
    return limparSessao();
  }

  public static Result dashboard()
  {
    return verificarSessao() ? ok(dashboard.render()) : redirect("/");
  }

  public static class Login
  {
    @Constraints.Required
    public String nomeUsuario;
    @Constraints.Required
    public String senha;

    /**
     * Valida das credenciais de login.
     *
     * @return mensagem de erro ou null, caso as credenciais sejam válidas
     */
    public String validar()
    {
      Usuario usuario = null;
      try
      {
        usuario = UsuarioController.autenticar(nomeUsuario, senha);
      }
      catch(AppException excecao)
      {
        return "Erro técnico, por favor tente novamente.";
      }

      if(usuario == null)
      {
        return "Usuário ou senha inválido";
      }

      return null;
    }
  }

  /**
   * Autentica usuário a partir das credenciais fornecidas
   * na página de login
   *
   * @return badRequest em caso de problemas com as credenciais ou redireciona para nova página
   */
  public static Result autenticar()
    throws AppException
  {
    Form<Login> formLogin = form(Login.class).bindFromRequest();

    if(formLogin.hasErrors())
    {
      return badRequest(index.render(formLogin));
    }
    else
    {
      Login login = formLogin.get();

      String valido = login.validar();

      if(valido == null)
      {
        iniciaSessao(login.nomeUsuario);
        return redirect( "/dashboard" );
      }
    }

    return badRequest(index.render(formLogin));
  }

  public static Boolean verificarSessao()
  {
    String usuarioConectado = session("conectado");

    return usuarioConectado != null ? true : false;
  }

  public static Result limparSessao()
  {
    session().clear();

    return redirect( "/" );
  }

  public static Boolean iniciaSessao(String nomeUsuario)
  {
    session("conectado", nomeUsuario);

    return verificarSessao();
  }
}
