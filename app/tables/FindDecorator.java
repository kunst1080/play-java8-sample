package tables;

import java.util.Optional;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Model;
import com.avaje.ebean.util.ClassUtil;

import tables.find.Where;

public class FindDecorator<ID, TABLE extends BaseTable> implements Where<TABLE> {

	private Model.Finder<ID, TABLE> finder = new Model.Finder<>(getTableClass());

	@SuppressWarnings("unchecked")
	private Class<TABLE> getTableClass() {
		return (Class<TABLE>) ClassUtil.getSecondArgumentType(getClass());
	}

	@Override
	public ExpressionList<TABLE> where() {
		return finder.where();
	}

	public Optional<TABLE> byId(ID id) {
		return Optional.ofNullable(finder.byId(id));
	}
}
