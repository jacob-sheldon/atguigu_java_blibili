package bean;

import java.sql.Date;

public class User {
	int id;
	String name;
	String email;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	Date birth;

	public User() {
		super();
	}

	public User(int id, String name, String email, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", birth=" + birth + "]";
	}

}
