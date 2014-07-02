package models.utils;

public class AppException extends Exception
{
  public AppException()
  {

  }

  public AppException(String mensagem)
  {
    super(mensagem);
  }

  public AppException(String mensagem, Throwable causa)
  {
    super(mensagem, causa);
  }

  public AppException(Throwable causa)
  {
    super(causa);
  }
}
