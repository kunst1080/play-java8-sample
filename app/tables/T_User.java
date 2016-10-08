package tables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import tables.find.All;
import tables.find.Fuzzy;

@Entity
@Table(name = "t_user")
public class T_User extends BaseTable {

	public static class Find extends FindDecorator<Long, T_User>
			implements All<T_User>, Fuzzy<T_User> {}

	public static Find find = new Find();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Required
	public String name;

	public Integer schoolYear;

	public Date birthDay;

	public Integer height;

	public String food;

	public boolean isEmpty() {
		return id == null;
	}
}
