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

  public static class formNovoUsuario{
    @Constraints.Required
    public String nomeUsuario;
    @Constraints.Required
    public String senha;
  }

  public static Usuario novoUsuario(String nomeUsuario, String senha)
    throws AppException
  {
    Usuario usuario = new Usuario();

    usuario.setNomeUsuario(nomeUsuario);

    usuario.save();

    mudaSenha(nomeUsuario, senha);

    return usuario;
  }

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

  public static void mudaSenha(String nomeUsuario, String senha)
    throws AppException
  {
    Usuario usuario = procuraPorNome(nomeUsuario);
    usuario.setSenha(Hash.criarSenha(senha));
    usuario.save();
  }
}