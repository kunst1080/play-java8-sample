package controllers;

import javax.inject.Singleton;

import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class Application extends Controller {

	public Result index() {
		return ok(views.html.index.render());
	}
}
