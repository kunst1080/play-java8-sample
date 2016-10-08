package tables;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

@MappedSuperclass
public abstract class BaseTable extends Model {

	@CreatedTimestamp
	public Date createdAt;

	@Version
	@UpdatedTimestamp
	public Date updatedAt;

}
