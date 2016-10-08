package tables.find;

import java.util.List;

public interface All<TABLE> extends Where<TABLE> {

	default List<TABLE> all() {
		return where().findList();
	}
}
