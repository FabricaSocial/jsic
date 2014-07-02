package models.utils;

import org.mindrot.jbcrypt.BCrypt;

import java.util.UUID;

public class Hash
{
  public static String criarSenha(String stringLimpa)
    throws AppException
  {
    if(stringLimpa == null)
    {
      throw new AppException("Senha não definida!");
    }

    return BCrypt.hashpw(stringLimpa, BCrypt.gensalt());
  }

  public static boolean checaSenha(String candidata, String senhaEncriptada)
  {
    if(candidata == null)
    {
      return false;
    }
    return BCrypt.checkpw(candidata, senhaEncriptada);
  }
}
