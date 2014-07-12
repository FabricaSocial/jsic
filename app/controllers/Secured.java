package controllers;

import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;

public class Secured extends Security.Authenticator
{

  @Override
  public String getUsername(Context context)
  {
    return context.session().get("conectado");
  }

  @Override
  public Result onUnauthorized(Context context)
  {
    context.session().clear();
    return redirect( "/" );
  }
}