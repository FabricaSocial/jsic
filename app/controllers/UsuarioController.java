package controllers;

import play.mvc.Controller;
import play.data.validation.Constraints;


import models.Usuario;
import models.utils.AppException;
import models.utils.Hash;

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
    return Usuario.find.where().eq("username", nomeUsuario).findUnique();
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
  public static Usuario novoUsuario(String nomeUsuario, String senha)
    throws AppException
  {
    Usuario usuario = new Usuario();

    usuario.setNomeUsuario(nomeUsuario);

    usuario.save();

    mudaSenha(nomeUsuario, senha);

    return usuario;
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

  /**
   * Altera a senha de um usuário existente
   *
   * @param nomeUsuario string contendo o nome de usuário o qual deseja-se mudar a senha
   * @param senha string contendo a nova senha não-criptografada do usuário
   */
  public static void mudaSenha(String nomeUsuario, String senha)
    throws AppException
  {
    Usuario usuario = procuraPorNome(nomeUsuario);
    if(usuario != null)
    {
      usuario.setSenha(Hash.criarSenha(senha));
      usuario.save();
    }
  }

  public static void deletaUsuario(String nomeUsuario)
    throws AppException
  {
    Usuario usuario = procuraPorNome(nomeUsuario);
    if(usuario != null)
    {
      
    }
  }
}