package models.utils;

import play.Logger;

public class ExcecaoFactory
{
  public static AppException getNovoAppException(Exception excecao)
  {
    Logger.error(excecao.getMessage());
    AppException app = new AppException();
    app.initCause(excecao);
    return app;
  }
}
