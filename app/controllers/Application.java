package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.UserForm;
import models.UserItem;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class Application extends Controller {

	private Form<UserForm> forms;
	private Form<UserItem> itemForms;

	@Inject
	public Application(FormFactory formFactory) {
		this.forms = formFactory.form(UserForm.class);
		this.itemForms = formFactory.form(UserItem.class);
	}

	public Result index() {
		Form<UserForm> requestForm = forms.bindFromRequest();
		if (requestForm.hasErrors()) {
			return badRequest(views.html.index.render(requestForm, new ArrayList<>()));
		}
		UserForm form = requestForm.get();
		List<UserItem> items = form.search();
		return ok(views.html.index.render(forms.fill(form), fill(items)));
	}

	private List<Form<UserItem>> fill(List<UserItem> items) {
		return items.stream()
				.map(itemForms::fill)
				.collect(Collectors.toList());
	}
}
