package tables.find;

import java.util.List;

import com.avaje.ebean.ExpressionList;

public interface Fuzzy<TABLE> extends Where<TABLE> {

	default List<TABLE> fuzzy(String value, String... columnNames) {
		ExpressionList<TABLE> ex = where();
		for (String c : columnNames) {
			ex = ex.like(c, "%" + value + "%");
		}
		return ex.findList();
	}
}
