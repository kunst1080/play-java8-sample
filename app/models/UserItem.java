package models;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import play.data.format.Formats;
import tables.T_User;

@Getter
@NoArgsConstructor
public class UserItem {

	Long id;

	String name;

	String schoolYear;

	@Formats.DateTime(pattern = "MM月dd日")
	Date birthDay;

	String height;

	String food;

	@Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
	Date createdAt;

	@Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
	Date updatedAt;

	public UserItem(T_User user) {
		this.id = user.id;
		this.name = user.name;
		this.schoolYear = user.schoolYear + "年生";
		this.birthDay = user.birthDay;
		this.height = user.height + "cm";
		this.food = user.food;
		this.createdAt = user.createdAt;
		this.updatedAt = user.updatedAt;
	}
}
