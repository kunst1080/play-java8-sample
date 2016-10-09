package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import tables.T_User;

@Singleton
public class UserController extends Controller {

	private Form<T_User> forms;

	@Inject
	public UserController(FormFactory formFactory) {
		this.forms = formFactory.form(T_User.class);
	}

	public Result init() {
		T_User user = new T_User();
		return ok(views.html.user.render(forms.fill(user), false, null));
	}

	public Result edit(Long id) {
		T_User user = T_User.find.byId(id).orElse(new T_User());
		if (user.isEmpty()) {
			return redirect(routes.UserController.init());
		}
		return ok(views.html.user.render(forms.fill(user), true, null));
	}

	@Transactional
	public Result create() {
		return insertOrUpdate(false);
	}

	@Transactional
	public Result update(Long id) {
		return insertOrUpdate(true);
	}

	private Result insertOrUpdate(boolean isEdit) {
		Form<T_User> requestForm = forms.bindFromRequest();
		if (requestForm.hasErrors()) {
			return badRequest(views.html.user.render(requestForm, isEdit, null));
		}
		T_User user = requestForm.get();
		if (user.isEmpty()) {
			user.save();
		} else {
			user.update();
		}
		return ok(views.html.user.render(forms.fill(user), true, "保存しました"));
	}

	@Transactional
	public Result delete(Long id) {
		System.out.println("DELETE:" + id);
		T_User user = T_User.find.byId(id).orElse(new T_User());
		if (user.isEmpty()) {
			return badRequest("delete error");
		}
		user.delete();
		return redirect(routes.Application.index());
	}
}
