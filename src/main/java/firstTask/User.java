package firstTask;

import java.util.List;

/**
 * Created by andrzej on 30.08.17.
 */
public class User {

	private Integer id;
	private Name name;
	private Integer age;
	private List<Skills> skillsList;

	public User(Integer id, Name name, Integer age, List<Skills> skillsList) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.skillsList = skillsList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Skills> getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List<Skills> skillsList) {
		this.skillsList = skillsList;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name=" + name +
				", age=" + age +
				", skillsList=" + skillsList +
				'}';
	}
}
