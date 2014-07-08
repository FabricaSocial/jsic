package controllers;

import play.Logger;
import play.data.Form;
import play.data.validation.Constraints;
import play.mvc.Controller;
import play.mvc.Result;

import models.Usuario;
import models.utils.AppException;

import views.html.index;

import static play.data.Form.form;

public class Application extends Controller
{
  public static Result index()
  {
    String nomeUsuario = ctx().session().get("nomeUsuario");
    if(nomeUsuario != null)
    {
      Usuario usuario = UsuarioController.procuraPorNome(nomeUsuario);
      if(usuario != null)
      {
        return TODO;
      }
      else
      {
        Logger.debug("Limpando credenciais inválidas");
        session().clear();
      }
    }
    return ok(index.render(form(Login.class)));
  }

  public static class Login
  {
    @Constraints.Required
    public String nomeUsuario;
    @Constraints.Required
    public String senha;

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
        return TODO;
      }
    }

    return badRequest(index.render(formLogin));
  }

}
