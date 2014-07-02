package controllers;

import play.*;
import play.mvc.*;

import models.Usuario;
import models.utils.AppException;
import play.data.validation.Constraints;

import views.html.*;

public class Application extends Controller {

   public static Result login()
   {
    return ok(login.render());
   }

}
