package controllers;

import play.mvc.Controller;

import models.Usuario;
import models.utils.AppException;
import models.utils.Hash;

public class UsuarioController extends Controller
{
  public static Usuario procuraPorNome(String nomeUsuario)
  {
    return Usuario.find.where().eq("username", nomeUsuario).findUnique();
  }

  public static Usuario autenticar(String nomeUsuario, String senhaLimpa)
    throws AppException
  {
    Usuario usuario = procuraPorNome(nomeUsuario);
    if(usuario != null)
    {
      if(Hash.checaSenha(senhaLimpa, usuario.senha))
      {
        return usuario;
      }
    }

    return null;
  }

  public void mudaSenha(String nomeUsuario, String senha)
    throws AppException
  {
    Usuario usuario = procuraPorNome(nomeUsuario);
    usuario.setSenha(Hash.criarSenha(senha));
    usuario.save();
  }
}