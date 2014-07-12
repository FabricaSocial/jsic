package controllers;

import models.Usuario;
import models.utils.AppException;
import models.utils.Hash;
import play.data.validation.Constraints;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.alterarSenha;

public class UsuarioController extends Controller
{
  /**
   * Realiza uma busca de usuário pelo seu nome de usuário
   *
   * @param nomeUsuario string contendo o nome de usuário a ser localizado
   * @return o usuário encontrado ou null, caso não encontre
   */
  public static Usuario procuraPorNome(String nomeUsuario)
  {
    return Usuario.find.where().eq("nome_usuario", nomeUsuario).findUnique();
  }

  public static class formNovoUsuario{
    @Constraints.Required
    public String nomeUsuario;
    @Constraints.Required
    public String senha;
  }

  /**
   * Cria um novo usuário
   *
   * @param nomeUsuario string contendo o nome de usuário desejado
   * @param senha string contendo a senha não-criptografada do novo usuário
   * @return o novo usuário criado
   */
  public static Result novoUsuario()
    throws AppException
  {
    Usuario usuario = new Usuario();

    return ok();
  }

  /**
   * Realiza a autenticação do usuário a partir de seu nome de usuário
   * e senha
   *
   * @param nomeUsuario string contendo o nome do usuário que deseja logar no sistema
   * @param senhaLimpa string contendo a senha não-criptografada do usuário
   * @return o objeto Usuário ou null, caso haja erro
   */
  public static Usuario autenticar(String nomeUsuario, String senhaLimpa)
    throws AppException
  {
    Usuario usuario = procuraPorNome(nomeUsuario);
    if(usuario != null)
    {
      if(Hash.checaSenha(senhaLimpa, usuario.getSenha()))
      {
        return usuario;
      }
    }

    return null;
  }

  @Security.Authenticated(Secured.class)
  public static Result atualizarSenha()
    throws AppException
  {
    return ok(alterarSenha.render());
  }

  /**
   * Altera a senha de um usuário existente
   *
   * @param nomeUsuario string contendo o nome de usuário o qual deseja-se mudar a senha
   * @param senha string contendo a nova senha não-criptografada do usuário
   */

  @Security.Authenticated(Secured.class)
  public static Result mudaSenha(String senhaAntiga, String senhaNova)
    throws AppException
  {
    Usuario usuario = procuraPorNome(session("conectado"));
    if(usuario != null)
    {
      if(Hash.checaSenha(senhaAntiga, usuario.getSenha()))
      {
        usuario.setSenha(Hash.criarSenha(senhaNova));
        usuario.save();

        return ok(alterarSenha.render());
      }
      else
      {
        return badRequest(alterarSenha.render());
      }
    }

    return badRequest(alterarSenha.render());
  }

  @Security.Authenticated(Secured.class)
  public static Result deletaUsuario()
    throws AppException
  {
    Usuario usuario = procuraPorNome(session("conectado"));
    if(usuario != null)
    {
      usuario.delete();

      return ok();
    }

    return badRequest();
  }
}